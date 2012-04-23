
<%@ page import="rent.Property" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'property.label', default: 'Property')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-property" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-property" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="address" title="${message(code: 'property.address.label', default: 'Address')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'property.city.label', default: 'City')}" />
					
						<g:sortableColumn property="state" title="${message(code: 'property.state.label', default: 'State')}" />
					
						<g:sortableColumn property="zipCode" title="${message(code: 'property.zipCode.label', default: 'Zip Code')}" />
					
						<g:sortableColumn property="heating" title="${message(code: 'property.heating.label', default: 'Heating')}" />
					
						<th><g:message code="property.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${propertyInstanceList}" status="i" var="propertyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${propertyInstance.id}">${fieldValue(bean: propertyInstance, field: "address")}</g:link></td>
					
						<td>${fieldValue(bean: propertyInstance, field: "city")}</td>
					
						<td>${fieldValue(bean: propertyInstance, field: "state")}</td>
					
						<td>${fieldValue(bean: propertyInstance, field: "zipCode")}</td>
					
						<td>${fieldValue(bean: propertyInstance, field: "heating")}</td>
					
						<td>${fieldValue(bean: propertyInstance, field: "user")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${propertyInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
