<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" />
	
	<xsl:param name="width" />
	<xsl:param name="height" />

	<xsl:template match="outlook-bar">

		<ilayer name="outlook" width="{$width}" height="100" clip="0,0,{$width},{$height}">

			<table width="{$width}" height="{$height}" border="1" cellspacing="0" bgcolor="#848284">
				<tr><td>&#160;</td></tr>
			</table>

			<layer name="arrowUp"   left="0" top="0" visibility="hidden">UP</layer>
			<layer name="arrowDown" left="0" top="0" visibility="hidden">DW</layer>

			<xsl:apply-templates />

		</ilayer>

		<script>refreshGroups();</script>
	</xsl:template>

	<xsl:template match="group">
		
		<xsl:variable name="id"><xsl:value-of select="generate-id()" /></xsl:variable>
		
		<layer name="{$id}" left="0" top="0" width="{$width}">

			<table width="100%" cellspacing="1">
				<tr>
					<td height="22" class="groupHeader">
						<a href="javascript:showGroup('{$id}')" class="groupHeader">
							<xsl:value-of select="@title" />
						</a>
					</td>
				</tr>
			</table>

			<ilayer name="content" width="{$width}" visibility="hidden">
				<table width="100%" cellspacing="6">

					<xsl:apply-templates />

				</table>
			</ilayer>

		</layer>
		
		<script>groups[ groups.length ] = '<xsl:value-of select="$id" />';</script>
	</xsl:template>

	<xsl:template match="item">

		<xsl:variable name="id"><xsl:value-of select="generate-id()" /></xsl:variable>

		<tr>
			<td class="item" height="54">
				<a href="#">
					<img border="0" src="{@icon}" />
					<br />
					<span class="item">
						<xsl:value-of select="@title" />
					</span>
				</a>
			</td>
		</tr>
	</xsl:template>
	
</xsl:stylesheet>