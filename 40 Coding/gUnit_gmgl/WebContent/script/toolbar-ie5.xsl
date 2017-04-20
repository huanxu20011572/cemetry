<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">

	<xsl:template match="/">
		<table border="0" cellspacing="0" class="toolbarHolder">
			<tr>
				<td>
					<span class="toolbarStart"></span>
				</td>
				<xsl:apply-templates select="/toolbar/*" />
			</tr>
		</table>
	</xsl:template>

	<xsl:template match="*/break">
		<td class="buttonOut">
			<span class="break"></span>
		</td>
	</xsl:template>

	<xsl:template match="*/item">
		<td onmouseover="buttonOver(this)" onmouseout="buttonOut(this)" onmousedown="buttonDown(this)" onmouseup="buttonClick(this)" onclick="os_itemClick(this)" nowrap="true">
			<xsl:attribute name="class">buttonOut</xsl:attribute>
			<xsl:attribute name="href"><xsl:value-of select="@href" /></xsl:attribute>
			<xsl:attribute name="target"><xsl:value-of select="@target" /></xsl:attribute>
			<xsl:attribute name="action"><xsl:value-of select="@action" /></xsl:attribute>
			<xsl:attribute name="id"><xsl:value-of select="@id" /></xsl:attribute>
			<xsl:if test=".[not(@image)]">
				<img class="buttonIcon" width="16" height="16" alt="" border="0">
					<xsl:attribute name="src"><xsl:value-of select="@icon" /></xsl:attribute>
				</img>
				<span class="buttonText"><xsl:value-of select="@title" /></span>
			</xsl:if>
			<xsl:if test=".[@image]">
				<img border="0">
					<xsl:attribute name="src"><xsl:value-of select="@image" /></xsl:attribute>
					<xsl:attribute name="alt"><xsl:value-of select="@title" /></xsl:attribute>
				</img>
			</xsl:if>
		</td>
	</xsl:template>

</xsl:stylesheet>       