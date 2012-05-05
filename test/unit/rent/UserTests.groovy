package rent

import grails.test.mixin.*
import org.junit.*


class UserTests {
void testConstraints() {
        def will = new User(username: "william")
        mockForConstraintsTests(User, [ will ]) 
        def testLL = new User() 
        assertFalse testLL.validate() 
        assertEquals "nullable",
            testLL.errors["username"] 
        assertEquals "nullable",
            testLL.errors["password"]
      
        testLL = new User(username: "william", password: "william") 
        assertFalse testLL.validate()
        
        assertEquals "unique", testLL.errors["username"] 
               
        testLL = new User(username: 'angelaloo', firstName: 'angela', lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertTrue testLL.validate()
    }
}
