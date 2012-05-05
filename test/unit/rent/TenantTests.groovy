package rent

import grails.test.mixin.*
import org.junit.*


class TenantTests {
void testConstraints() {
        def tenant = new Tenant(firstName: "Tinn", email: "tinn", phone: "207730089")
        mockForConstraintsTests(Tenant,[tenant]) 
        def testT = new Tenant() 
        assertFalse testT.validate() 
        assertEquals "nullable",
        testT.errors["lastName"] 
        assertEquals "nullable",
        testT.errors["phone"]
      
        testT = new Tenant(firstName: "henry", lastName: "sugar", email: "henry@gmail.com",
            phone: "2077334987") 
        assertFalse testT.validate()      
        assertTrue(testT.hasErrors())
               
        testT = new Tenant(firstName: "henry", lastName: "sugar", email: "henry@gmail.com", 
            phone: "2077334987", creditScore: "300", prevLandlord: "harry", 
            prevAddress: "7 seely ln", prevLandlordPhone: "9876543456", comments: "heyhey")
      //  assertTrue testT.validate()
        assertFalse(testT.hasErrors())
    }
}
