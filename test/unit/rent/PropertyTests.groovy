package rent
import grails.test.mixin.*
import org.junit.*


class PropertyTests {
 void testConstraints() {
        def place = new Property(address: "5 sydney way")
        mockForConstraintsTests(Property,[place]) 
        def testP = new Property() 

        assertFalse testP.validate() 
        assertEquals "nullable",
            testP.errors["address"] 
        assertEquals "nullable",
            testP.errors["state"]
      
        testP = new Property(address: "5 sydney way", city: "portland", state: "meine", zipCode: "04102", heating: "oil") 
        assertFalse testP.validate()      
        assertTrue(testP.hasErrors())
               
        def testP1 = new Property(address: "5 way", city: "Portland", state: "Maine", zipCode: "04101", heating: "gas")
        assertFalse (testP1.hasErrors())
    }
}
