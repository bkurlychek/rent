<html>
   <head>
      <title>
               Properties for ${landlord.firstName}
      </title>
      <meta name="layout" content="main"/> 
   </head>
<body>
  
  
  <g:if test ="${assetAmt == 0}">
    <h1>${landlord.firstName}: You currently have ${assetAmt} properties. Would you like to 
              <g:link controller="property" action="create">      
      add one
                      
        
              </g:link>?
    </h1>
  </g:if>
  <g:else>
    <h1>${assetAmt} Properties for ${landlord.firstName}</h1>
  </g:else>
<br>
<div class="allProps" width="30px">
  <table width="30px">
  <g:each in="${landlord.asset}" var="asset">
    <tr width="30px">
      <td>
        ${asset.address}
      </td>               
      <td>
        ${asset.city}
      </td>
      <td>
        ${asset.state}
      </td>
      <td>
        ${asset.zipCode}
      </td>                            
    </tr>
        </g:each>

</table>
    </div>
   </body>
</html>

