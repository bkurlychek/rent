<%@ page import="rent.Tenant" %>



<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="tenant.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${tenantInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="tenant.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${tenantInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="tenant.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${tenantInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'phone', 'error')} required">
	<label for="phone">
		<g:message code="tenant.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phone" pattern="${tenantInstance.constraints.phone.matches}" required="" value="${tenantInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'creditScore', 'error')} required">
	<label for="creditScore">
		<g:message code="tenant.creditScore.label" default="Credit Score" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="creditScore" from="${tenantInstance.constraints.creditScore.inList}" required="" value="${fieldValue(bean: tenantInstance, field: 'creditScore')}" valueMessagePrefix="tenant.creditScore"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'prevLandlord', 'error')} ">
	<label for="prevLandlord">
		<g:message code="tenant.prevLandlord.label" default="Prev Landlord" />
		
	</label>
	<g:textField name="prevLandlord" value="${tenantInstance?.prevLandlord}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'prevAddress', 'error')} ">
	<label for="prevAddress">
		<g:message code="tenant.prevAddress.label" default="Prev Address" />
		
	</label>
	<g:textField name="prevAddress" maxlength="100" value="${tenantInstance?.prevAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'prevLandlordPhone', 'error')} ">
	<label for="prevLandlordPhone">
		<g:message code="tenant.prevLandlordPhone.label" default="Prev Landlord Phone" />
		
	</label>
	<g:textField name="prevLandlordPhone" pattern="${tenantInstance.constraints.prevLandlordPhone.matches}" value="${tenantInstance?.prevLandlordPhone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="tenant.comments.label" default="Comments" />
		
	</label>
	<g:textArea name="comments" cols="40" rows="5" maxlength="500" value="${tenantInstance?.comments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenantInstance, field: 'unit', 'error')} required">
	<label for="unit">
		<g:message code="tenant.unit.label" default="Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unit" name="unit.id" from="${rent.Unit.list()}" optionKey="id" required="" value="${tenantInstance?.unit?.id}" class="many-to-one"/>
</div>

