package rent

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class SiteInfoUnitTests {
	void testConstraints() {
		def siteinfo = new SiteInfo(email: "a")
		mockForConstraintsTests(SiteInfo,[siteinfo])
		def testU = new SiteInfo()
		assertFalse testU.validate()
		assertEquals "nullable",
		testU.errors["email"]
		assertEquals "nullable",
		testU.errors["comments"]
	  
		testU = new SiteInfo(email: "aa.com", name: "angela", comments: "comments")
		assertFalse testU.validate()
		assertTrue(testU.hasErrors())
			   
		testU = new Property(email: "a@a.com", name: "angela", comments: "comments")
		assertFalse(testU.hasErrors())
	}
}
