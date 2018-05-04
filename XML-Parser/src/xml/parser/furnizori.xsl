<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match="/">
  <html>
   <body>
    <h2>Comenzile mele</h2>
    <table>
     <tr>
      <th>Furnizor</th>
      <th>NumeProdus</th>
      <th>Lot</th>
      <th>Data Expirare</th>
      <th>Bucati</th>
      <th>Unitate de masura</th>
     </tr>
     <xsl:for-each select="comenzi/furnizor/produs">
      <tr>
       <td>
        <xsl:value-of select="../@name" />
       </td> 
       <td>
        <xsl:value-of select="name" />
       </td>
       <td>
        <xsl:value-of select="lot" />
       </td>
       <td>
        <xsl:value-of select="data_expirare" />
       </td>
       <td>
        <xsl:value-of select="cantitate" />
       </td>
       <td>
        <xsl:value-of select="cantitate/@unitate_de_masura" />
       </td>
      </tr>
     </xsl:for-each>
    </table>
   </body>
  </html>
 </xsl:template>
</xsl:stylesheet>
