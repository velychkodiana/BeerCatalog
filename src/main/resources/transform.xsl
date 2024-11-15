<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <!-- Початок HTML-документа -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Beer Catalog</title>
                <style>
                    table { border-collapse: collapse; width: 100%; }
                    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
                    th { background-color: #f2f2f2; }
                </style>
            </head>
            <body>
                <h2>Beer Catalog</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Manufacturer</th>
                    </tr>
                    <xsl:for-each select="//Beer">
                        <tr>
                            <td><xsl:value-of select="BeerName"/></td>
                            <td><xsl:value-of select="Type"/></td>
                            <td><xsl:value-of select="Manufacturer"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
