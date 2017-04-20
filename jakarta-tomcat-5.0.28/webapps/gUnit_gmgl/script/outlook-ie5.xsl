<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">

	<xsl:template match="/">
		<table border="0" cellspacing="0" class="outlookPanel">
			<xsl:apply-templates select="outlook-bar/group" />			
		</table>
	</xsl:template>

	<xsl:template match="*/group">
		<tr>
			<td 
				onclick="os_showGroup(this)"
				class="groupHeader" 
				onmouseover="this.className='groupHeaderOver'" 
				onmouseout="this.className='groupHeader'"
				onmousedown="this.className='groupHeaderClick'" 
				onmouseup="this.className='groupHeaderOver'"
			>
				<xsl:value-of select="@title" />
			</td>
		</tr>
		<tr>
			<td>
				<xsl:attribute name="class">groupPanelHidden</xsl:attribute>
				<div class="clippedRegion">
					<xsl:apply-templates select="item" />
				</div>
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="*/item">
		<p 
			class="iconSection"
			onmouseover="this.all.icon.className='iconOver'" 
			onmouseout="this.all.icon.className='icon'"
			onmousedown="this.all.icon.className='iconClick'" 
			onmouseup="this.all.icon.className='iconOver'"
			onclick="os_itemClick(this)"
		>
			<xsl:attribute name="action"><xsl:value-of select="@action" /></xsl:attribute>
			<xsl:attribute name="target"><xsl:value-of select="@target" /></xsl:attribute>
			<xsl:attribute name="href"><xsl:value-of select="@href" /></xsl:attribute>
			<span id="icon" class="icon"><img width="32" height="32" alt="" border="0">
				<xsl:attribute name="src"><xsl:value-of select="@icon" /></xsl:attribute>
			</img></span>
			<br />
			<span class="iconLabel"><xsl:value-of select="." /><xsl:value-of select="@title" /></span>
		</p>
	</xsl:template>	
		
</xsl:stylesheet>