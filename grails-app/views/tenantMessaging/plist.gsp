<html>
<head>
<meta name="layout" content="main" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tenant Messaging</title>
</head>
<body>
<br>
<dt style="margin-left: 2em; font-size: .9em; font-family: tahoma">
			Enter a property address to send a message to the tenants who live there.<br>	</dt>
	
	<g:message code="${flash.message}" args="${flash.args}"
           default="${flash.default}" style = "margin-left: 1.5em; font-style: bold; color: red"/>
	 <g:form action="plist" style ="font-family: tahoma; font-size: .9em;
                margin-left: 15em;">
            <dl>
            <br>
            <br>
			<dt style = "margin-left: 1.5em; font-style: bold;">Property Address</dt>
			<dd style = "margin-left: 1.5em; font-style: bold;">
				<g:textField name="address" value="${tMess?.address}" />
				<g:hasErrors bean="${tMess}" field="address">
                        <g:eachError bean="${tMess}" field="address">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors>
                </dd>
			</dd>
			<br>
			
			<dt style = "margin-left: 1.5em; font-style: bold;">
			<g:submitButton name="plist" value="Search for Tenants" style="font-family: tahoma;"/></dt>
	</dl>
	</g:form>
</body>
</html>


