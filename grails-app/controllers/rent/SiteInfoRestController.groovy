package rent

import grails.converters.XML

class SiteInfoRestController {

	//def list = { render Property.list() as XML }
	
	//def show = {
	//	def prop = Property.get(params.id)
	//	render prop as XML
	//}
    def contactus = { 
		render Property.list() as XML 
	}
}
