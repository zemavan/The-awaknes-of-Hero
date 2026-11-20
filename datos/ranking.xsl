<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8"/>

  <xsl:template match="/ranking">
    <html>
      <head>
        <meta charset="UTF-8"/>
        <title>Ranking</title>
        <link rel="stylesheet" href="ranking.css"/>
      </head>
      <body>
        <h1>Ranking</h1>

        <xsl:if test="not(registro)">
          <p>El ranking esta vacio.</p>
        </xsl:if>

        <xsl:if test="registro">
          <table>
            <tr>
              <th>Jugador</th>
              <th>Puntos</th>
            </tr>
            <xsl:for-each select="registro">
              <xsl:sort select="puntos" data-type="number" order="descending"/>
              <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="puntos"/></td>
              </tr>
            </xsl:for-each>
          </table>
        </xsl:if>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
