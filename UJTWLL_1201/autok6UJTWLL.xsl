<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#ffff00">
                        <th>Város</th>
                        <th>Darab</th>
                        <th>Összár</th>
                    </tr>
                    <tr>
                        <td>Miskolc</td>
                        <td><xsl:value-of select="count(//auto/tulaj[varos='Miskolc'])"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Eger</td>
                        <td><xsl:value-of select="count(//auto/tulaj[varos='Eger'])"/></td>
                        <td></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>