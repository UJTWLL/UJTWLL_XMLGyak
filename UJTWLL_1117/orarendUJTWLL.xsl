<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>FM órarend - 2021/22 I. félév</h2>
    <table border="1">
      <tr bgcolor="#00cc00">
        <th>ID</th>
        <th>Tipus</th>
        <th>Nap</th>
        <th>Kezdes</th>
        <th>Vege</th>
        <th>Helyszin</th>
        <th>Oktato</th>
        <th>Szak</th>
      </tr>
      <xsl:for-each select="orarend/ora">
        <tr>
          <td><xsl:value-of select="@id"/></td>
          <td><xsl:value-of select="@tipus"/></td>
          <td><xsl:value-of select="idopont/nap"/></td>
          <td><xsl:value-of select="idopont/tol"/></td>
          <td><xsl:value-of select="idopont/ig"/></td>
          <td><xsl:value-of select="helyszin"/></td>
          <td><xsl:value-of select="oktato"/></td>
          <td><xsl:value-of select="szak"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>