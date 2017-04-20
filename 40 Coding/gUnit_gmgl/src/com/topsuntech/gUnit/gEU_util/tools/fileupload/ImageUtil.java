package com.topsuntech.gUnit.gEU_util.tools.fileupload;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtil {

	private static final String FORMAT_NAME = "JPEG";

	private static final String TEMP_PATH = System.getProperty("TMPDIR");

	/**
	 * 放大/缩小图片
	 * 
	 * @param source
	 *            源输入流
	 * @param ratio
	 *            放大/缩小比率
	 * 
	 * @return result
	 * @throws IOException
	 */
	public static BufferedImage resize(FileInputStream source, double ratio)
			throws IOException {
		return resize(ImageIO.read(source), ratio);
	}

	/**
	 * @param source
	 *            源图片
	 * @param ratio
	 *            放大/缩小比率
	 * @return
	 */
	public static BufferedImage resize(BufferedImage source, double ratio) {
		AffineTransform at = new AffineTransform();
		at.scale(ratio, ratio);
		BufferedImageOp bi = new AffineTransformOp(at, null);
		return bi.filter(source, null);
	}

	/**
	 * 改变图片长度和宽度
	 * 
	 * @param source
	 *            源输入流
	 * @param maxHigh
	 *            最大高度
	 * @param maxWidth
	 *            最大宽度
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage resize(InputStream source, int maxHigh,
			int maxWidth) throws IOException {
		BufferedImage biSrc = ImageIO.read(source);
		int sourceHigh = biSrc.getHeight();
		int sourceWidth = biSrc.getWidth();
		double ratio = 1;
		if (sourceHigh > maxHigh || sourceWidth > maxWidth) {
			ratio = ((double) maxHigh) / ((double) sourceHigh);
			if (ratio * sourceWidth > maxWidth) {
				ratio = ((double) maxWidth) / ((double) sourceWidth);
			}
			return resize(biSrc, ratio);
		}
		return biSrc;
	}


	/**
	 * 改变图片大小
	 * @param imageIn
	 * @param width
	 * @param height
	 * @param scaleQuality
	 * @param maintainAspect
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage scaleImage(BufferedImage imageIn, int width,
			int height, int scaleQuality, boolean maintainAspect)
			throws IOException {

		if (maintainAspect && width != -1 && height != -1) {

			// Calculate the height and width - this is done automatically if
			// not constrained
			int im_width = imageIn.getWidth(null);
			int im_height = imageIn.getHeight(null);

			int tmp_w;
			int tmp_h;

			tmp_h = height;
			tmp_w = (int) (((double) height / (double) im_height) * im_width);

			if (tmp_w > width) {
				tmp_w = width;
				tmp_h = (int) (((double) width / (double) im_width) * im_height);
			}

			width = tmp_w;
			height = tmp_h;
		}

		// Scales the image
		Image imageIn2 = imageIn.getScaledInstance(width, height, scaleQuality);

		// Converts the Image to a BufferedImage
		BufferedImage scaled = new BufferedImage(imageIn2.getWidth(null),
				imageIn2.getHeight(null), BufferedImage.TYPE_INT_RGB);
		scaled.createGraphics().drawImage(imageIn2, 0, 0, null);

		return scaled;
	}

	public static File writeImageToFile(BufferedImage image, String imageName)
			throws IOException {
		File file = new File(imageName);
		ImageIO.write(image, FORMAT_NAME, file);
		return file;
	}

	public static ByteArrayOutputStream writeImageToStream(BufferedImage image)
			throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ImageIO.write(image, FORMAT_NAME, stream);
		return stream;
	}

	public static void main(String[] args) {

	}
}
