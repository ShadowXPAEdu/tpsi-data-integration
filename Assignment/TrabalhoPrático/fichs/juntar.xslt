<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" />
  
    <xsl:template match="juntar">
      <juntar>
        <xsl:apply-templates select="camaras" />
        <xsl:apply-templates select="contratos" />
      </juntar>
    </xsl:template>

</xsl:stylesheet>
