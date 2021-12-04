<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Hallgatók apply-template</h2>
    
    <xsl:for-each select="class/student">
    	<p>
    		ID: <xsl:value-of select="@id"/><br/>
    		Vezetéknév: <xsl:value-of select="vezeteknev"/><br/>
    		Keresztnév: <xsl:value-of select="keresztnev"/><br/>
    		<xsl:value-of select="becenev"/> Kor: <xsl:value-of select="kor"/><br/>
    		Fizetés: <xsl:value-of select="fizetes"/><br/>
    	</p>
    </xsl:for-each>

  </body>
  </html>
</xsl:template>

</xsl:stylesheet>