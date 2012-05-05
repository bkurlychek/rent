
<%@ page import="rent.Unit" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'unit.label', default: 'Unit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-unit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-unit" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list unit">
			
				<g:if test="${unitInstance?.unitNo}">
				<li class="fieldcontain">
					<span id="unitNo-label" class="property-label"><g:message code="unit.unitNo.label" default="Unit No" /></span>
					
						<span class="property-value" aria-labelledby="unitNo-label"><g:fieldValue bean="${unitInstance}" field="unitNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${unitInstance?.sqFeet}">
				<li class="fieldcontain">
					<span id="sqFeet-label" class="property-label"><g:message code="unit.sqFeet.label" default="Sq Feet" /></span>
					
						<span class="property-value" aria-labelledby="sqFeet-label"><g:fieldValue bean="${unitInstance}" field="sqFeet"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${unitInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="unit.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${unitInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${unitInstance?.bedrooms}">
				<li class="fieldcontain">
					<span id="bedrooms-label" class="property-label"><g:message code="unit.bedrooms.label" default="Bedrooms" /></span>
					
						<span class="property-value" aria-labelledby="bedrooms-label"><g:fieldValue bean="${unitInstance}" field="bedrooms"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${unitInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="unit.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${unitInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${unitInstance?.asset}">
				<li class="fieldcontain">
					<span id="asset-label" class="property-label"><g:message code="unit.asset.label" default="Asset" /></span>
					
						<span class="property-value" aria-labelledby="asset-label"><g:link controller="property" action="show" id="${unitInstance?.asset?.id}">${unitInstance?.asset?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${unitInstance?.tenants}">
				<li class="fieldcontain">
					<span id="tenants-label" class="property-label"><g:message code="unit.tenants.label" default="Tenants" /></span>
					
						<g:each in="${unitInstance.tenants}" var="t">
						<span class="property-value" aria-labelledby="tenants-label"><g:link controller="tenant" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${unitInstance?.id}" />
					<g:link class="edit" action="edit" id="${unitInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
