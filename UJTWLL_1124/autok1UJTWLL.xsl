<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#ffff00">
                        <th>Rendszám</th>
                        <th>Ár</th>
                    </tr>
                    <xsl:for-each select="autok/auto">
                        <xsl:sort select="ar"/>
                        <tr>
                            <td><xsl:value-of select="@rsz"/></td>
                            <td><xsl:value-of select="ar"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>