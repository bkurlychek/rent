<%@ page import="rent.Property" %>



<div class="fieldcontain ${hasErrors(bean: propertyInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="property.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" required="" value="${propertyInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: propertyInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="property.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${propertyInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: propertyInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="property.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="state" from="${propertyInstance.constraints.state.inList}" required="" value="${propertyInstance?.state}" valueMessagePrefix="property.state"/>
</div>

<div class="fieldcontain ${hasErrors(bean: propertyInstance, field: 'zipCode', 'error')} required">
	<label for="zipCode">
		<g:message code="property.zipCode.label" default="Zip Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="zipCode" pattern="${propertyInstance.constraints.zipCode.matches}" required="" value="${propertyInstance?.zipCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: propertyInstance, field: 'heating', 'error')} ">
	<label for="heating">
		<g:message code="property.heating.label" default="Heating" />
		
	</label>
	<g:textField name="heating" value="${propertyInstance?.heating}"/>
</div>

