
<%@ page import="rent.Tenant" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tenant.label', default: 'Tenant')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tenant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tenant" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tenant">
			
				<g:if test="${tenantInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="tenant.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${tenantInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="tenant.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${tenantInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="tenant.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${tenantInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.phone}">
				<li class="fieldcontain">
					<span id="phone-label" class="property-label"><g:message code="tenant.phone.label" default="Phone" /></span>
					
						<span class="property-value" aria-labelledby="phone-label"><g:fieldValue bean="${tenantInstance}" field="phone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.creditScore}">
				<li class="fieldcontain">
					<span id="creditScore-label" class="property-label"><g:message code="tenant.creditScore.label" default="Credit Score" /></span>
					
						<span class="property-value" aria-labelledby="creditScore-label"><g:fieldValue bean="${tenantInstance}" field="creditScore"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.prevLandlord}">
				<li class="fieldcontain">
					<span id="prevLandlord-label" class="property-label"><g:message code="tenant.prevLandlord.label" default="Prev Landlord" /></span>
					
						<span class="property-value" aria-labelledby="prevLandlord-label"><g:fieldValue bean="${tenantInstance}" field="prevLandlord"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.prevAddress}">
				<li class="fieldcontain">
					<span id="prevAddress-label" class="property-label"><g:message code="tenant.prevAddress.label" default="Prev Address" /></span>
					
						<span class="property-value" aria-labelledby="prevAddress-label"><g:fieldValue bean="${tenantInstance}" field="prevAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.prevLandlordPhone}">
				<li class="fieldcontain">
					<span id="prevLandlordPhone-label" class="property-label"><g:message code="tenant.prevLandlordPhone.label" default="Prev Landlord Phone" /></span>
					
						<span class="property-value" aria-labelledby="prevLandlordPhone-label"><g:fieldValue bean="${tenantInstance}" field="prevLandlordPhone"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="tenant.comments.label" default="Comments" /></span>
					
						<span class="property-value" aria-labelledby="comments-label"><g:fieldValue bean="${tenantInstance}" field="comments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="tenant.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${tenantInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenantInstance?.unit}">
				<li class="fieldcontain">
					<span id="unit-label" class="property-label"><g:message code="tenant.unit.label" default="Unit" /></span>
					
						<span class="property-value" aria-labelledby="unit-label"><g:link controller="unit" action="show" id="${tenantInstance?.unit?.id}">${tenantInstance?.unit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tenantInstance?.id}" />
					<g:link class="edit" action="edit" id="${tenantInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
