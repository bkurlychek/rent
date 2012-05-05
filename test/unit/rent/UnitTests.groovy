package rent



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Unit)
class UnitTests {
 void testConstraints() {
        def unit = new Unit(unitNo: "5")
        mockForConstraintsTests(Unit,[unit]) 
        def testU = new Unit() 
        assertFalse testU.validate() 
        assertEquals "nullable",
        testU.errors["unitNo"] 
        assertEquals "nullable",
        testU.errors["description"]
      
        testU = new Unit(unitNo: "3", sqFeet: "700", description: "a pretty neato place", 
            bedrooms: "4", status: "free")
        assertFalse testU.validate()      
        assertTrue(testU.hasErrors())
               
        testU = new Property(unitNo: "3", sqFeet: "700", description: "a pretty neato place", 
            bedrooms: "4", status: "Available")
        assertFalse(testU.hasErrors())
    }
}
