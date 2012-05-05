
<%@ page import="rent.Property" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'property.label', default: 'Property')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-property" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-property" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list property">
			
				<g:if test="${propertyInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="property.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${propertyInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${propertyInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="property.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${propertyInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${propertyInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="property.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${propertyInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${propertyInstance?.zipCode}">
				<li class="fieldcontain">
					<span id="zipCode-label" class="property-label"><g:message code="property.zipCode.label" default="Zip Code" /></span>
					
						<span class="property-value" aria-labelledby="zipCode-label"><g:fieldValue bean="${propertyInstance}" field="zipCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${propertyInstance?.heating}">
				<li class="fieldcontain">
					<span id="heating-label" class="property-label"><g:message code="property.heating.label" default="Heating" /></span>
					
						<span class="property-value" aria-labelledby="heating-label"><g:fieldValue bean="${propertyInstance}" field="heating"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${propertyInstance?.units}">
				<li class="fieldcontain">
					<span id="units-label" class="property-label"><g:message code="property.units.label" default="Units" /></span>
					
						<g:each in="${propertyInstance.units}" var="u">
						<span class="property-value" aria-labelledby="units-label"><g:link controller="unit" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${propertyInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="property.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${propertyInstance?.user?.id}">${propertyInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${propertyInstance?.id}" />
					<g:link class="edit" action="edit" id="${propertyInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
