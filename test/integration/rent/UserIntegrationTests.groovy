package rent

import static org.junit.Assert.*
import org.junit.*

class UserIntegrationTests {

void testSave(){
        def user = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull user.save()
        assertNotNull user.username
        def founduser = User.get(user.id)
        assertEquals ('angelaloo', founduser.username)
    }
    
    void testSaveAndUpdate(){
        def user = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull user.save()
        
        def founduser = User.get(user.id)
        founduser.password = 'password'
        founduser.save()
        
        def editeduser = User.get(user.id)
        assertEquals 'password', editeduser.password
    }
    
    void testSaveThenDelete(){
        def user = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull user.save()
        
        def founduser = User.get(user.id)
        founduser.delete()
        
        assertFalse user.exists(founduser.id)
    }
    
    void testIncorrectSave(){
        def user = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxseyyahoo.com', password:'abc',phone:'(207) 730-4455')
        
        assertFalse user.validate()
        assertTrue user.hasErrors()
        
        def errors = user.errors
        
        assertEquals "email.invalid",
            errors.getFieldError("email").code
        assertEquals "angela.doxseyyahoo.com",
            errors.getFieldError("email").rejectedValue
    }
    void testIncorrectSaveCorrected(){
        def user = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxseyyahoo.com', password:'abc',phone:'(207) 730-4455')
        assertFalse (user.validate())
        assertTrue (user.hasErrors())
        assertNull user.save()
        
        user.password = "betternow"
        user.email = "angela.doxsey@yahoo.com"
        assertTrue(user.validate())
        assertFalse(user.hasErrors())
        assertNotNull user.save()
    }
}


