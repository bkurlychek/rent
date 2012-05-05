<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta name="layout" content="main" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tenant Message</title>
</head>
<body>
	<div>
		<br>
		<dt style="margin-left: 19em; font-size: .9em; font-family: tahoma">
			Your message will be sent to the following tenants: <br> <br>			
			<g:each in="${session.tenans}" var="tenant">
				<g:each in="${tenant}" var="ten">
					${ten.email}
					<br>
				</g:each>
			</g:each>
			
			
			
			
		</dt>
		<br>
	</div>

	<h1 style="margin-left: 12.2em; font-size: 1.4em;">Tenant Message</h1>

	<g:form controller="tenantMessaging" action="send"
		style="font-family: tahoma; font-size: .9em;
                margin-left: 19em;">

		<dt>Type the Content of Your Message Here:</dt>
		<dd>
			<g:textArea name="content" value="${tMess?.content}" />
			<g:hasErrors bean="${tMess}" field="comments">
				<g:eachError bean="${tMess}" field="comments">
					<p style="color: red;">
						<g:message error="${it}" />
					</p>
				</g:eachError>
			</g:hasErrors>
		</dd>

		<br>
		<dt>
		<g:hiddenField name="tAddress" value="${session.tAddress}"></g:hiddenField>
			<g:submitButton name="send" value="Submit"
				style="font-family: tahoma;" />
		</dt>
		</dl>

	</g:form>
</body>
</html>

