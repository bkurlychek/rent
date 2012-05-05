package rent
import grails.converters.XML

class PropertyRestController {

	def list = { render Property.list() as XML }

	def show = {
		def prop = Property.get(params.id)
		render prop as XML
	}

	def save = {
		def xml = request.XML
		def property = new Property()
		property.address = xml.address.text()
		property.city = xml.city.text()
		property.state = xml.state.text()
		property.zipCode = xml.zipCode.text()
		property.heating = xml.heating.text()

		def markup
		if (property.save()) {
			markup = {
				status("OK")
			}
		}
		else {
			markup = {
				status("FAIL")
			}
		}
		render contentType: "text/xml; charset=utf-8",
				markup
	}
}
