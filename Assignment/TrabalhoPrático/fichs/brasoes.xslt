<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" />

  <xsl:template match="camaras">
    <html>
      <head>
        <title>
          <xsl:text>Brasões</xsl:text>
        </title>
      </head>
      <body>
        <xsl:apply-templates select="camara" />
      </body>
    </html>
  </xsl:template>

  <xsl:template match="camara">
    <p>
      <xsl:text>Brasão de </xsl:text><xsl:value-of select="municipio" />
    </p>
    <img src="{brasao}" />
    <hr />
  </xsl:template>

</xsl:stylesheet>
