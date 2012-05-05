
<%@ page import="rent.Unit" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'unit.label', default: 'Unit')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-unit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-unit" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="unitNo" title="${message(code: 'unit.unitNo.label', default: 'Unit No')}" />
					
						<g:sortableColumn property="sqFeet" title="${message(code: 'unit.sqFeet.label', default: 'Sq Feet')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'unit.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="bedrooms" title="${message(code: 'unit.bedrooms.label', default: 'Bedrooms')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'unit.status.label', default: 'Status')}" />
					
						<th><g:message code="unit.asset.label" default="Asset" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${unitInstanceList}" status="i" var="unitInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${unitInstance.id}">${fieldValue(bean: unitInstance, field: "unitNo")}</g:link></td>
					
						<td>${fieldValue(bean: unitInstance, field: "sqFeet")}</td>
					
						<td>${fieldValue(bean: unitInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: unitInstance, field: "bedrooms")}</td>
					
						<td>${fieldValue(bean: unitInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: unitInstance, field: "asset")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${unitInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
