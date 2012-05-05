package rent

import static org.junit.Assert.*
import grails.test.mixin.*
import grails.test.mixin.support.*
import grails.test.ControllerUnitTestCase

class PropertyRestControllerUnitTests extends ControllerUnitTestCase {
	protected void setUp() {
		super.setUp()
		mockDomain(Property, [
			new Property(address: "5 way", city: "Portland", state: "Maine", zipCode: "04101", heating: "gas"),
			new Property(address: "5 nay", city: "Nortland", state: "Maine", zipCode: "04101", heating: "gas"),
			new Property(address: "5 say", city: "Sortland", state: "Maine", zipCode: "04101", heating: "gas")])
	}
	void testList(){
		//this.controller.list()
		//def responseContent = this.controller.response.contentAsString
		//def xml = new XmlSlurper().parseText(responseContent)
	}
	/*void testShow() {
		this.controller.params.id = 1
		this.controller.show()
		def responseContent = this.controller.response.contentAsString
		def xml = new XmlSlurper().parseText(
				responseContent)
		assertEquals "5 way", xml.address.text()
	}
	/*void testSave() {
		mockDomain(User, [ new User(username: "peter") ])
		setXmlRequestContent {
			post {
				content("A new message")
				user(id: 1)
			}
		}
	}*/
}
