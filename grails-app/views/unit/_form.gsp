<%@ page import="rent.Unit" %>



<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'unitNo', 'error')} required">
	<label for="unitNo">
		<g:message code="unit.unitNo.label" default="Unit No" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="unitNo" pattern="${unitInstance.constraints.unitNo.matches}" required="" value="${unitInstance?.unitNo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'sqFeet', 'error')} required">
	<label for="sqFeet">
		<g:message code="unit.sqFeet.label" default="Sq Feet" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="sqFeet" required="" value="${fieldValue(bean: unitInstance, field: 'sqFeet')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="unit.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" value="${unitInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'bedrooms', 'error')} required">
	<label for="bedrooms">
		<g:message code="unit.bedrooms.label" default="Bedrooms" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="bedrooms" from="${unitInstance.constraints.bedrooms.inList}" required="" value="${fieldValue(bean: unitInstance, field: 'bedrooms')}" valueMessagePrefix="unit.bedrooms"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="unit.status.label" default="Status" />
		
	</label>
	<g:select name="status" from="${unitInstance.constraints.status.inList}" value="${unitInstance?.status}" valueMessagePrefix="unit.status" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'asset', 'error')} required">
	<label for="asset">
		<g:message code="unit.asset.label" default="Asset" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="asset" name="asset.id" from="${rent.Property.list()}" optionKey="id" required="" value="${unitInstance?.asset?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'tenants', 'error')} ">
	<label for="tenants">
		<g:message code="unit.tenants.label" default="Tenants" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${unitInstance?.tenants?}" var="t">
    <li><g:link controller="tenant" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="tenant" action="create" params="['unit.id': unitInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'tenant.label', default: 'Tenant')])}</g:link>
</li>
</ul>

</div>

