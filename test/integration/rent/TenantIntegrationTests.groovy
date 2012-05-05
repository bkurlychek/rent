package rent

import static org.junit.Assert.*
import org.junit.*

class TenantIntegrationTests {
void testSave(){
         //create a landlord
       def landlord = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull landlord.save()
        //create a property
        def property = new Property(
            address: '16 street', 
            city: 'portland', 
            state:'Maine',
            zipCode:'04102', 
            heating:'oil')
        
        // join landlord to property
        landlord.addToAsset(property)
        
        assertNotNull property.save()
        assertNotNull property.state
        def foundProperty = Property.get(property.id)
        assertEquals ('Maine', foundProperty.state)
        
        def unit = new Unit(
            unitNo:'g',
            sqFeet: '1200',
            //byte[] photo
            description: 'a pretty sweet unit, yo',
            bedrooms:'9',
            status: 'Available'
        )
        
        //join property to a unit
        property.addToUnits(unit)
        
        assertNotNull unit.save()
        assertNotNull unit.unitNo
        def foundUnit = Unit.get(unit.id)
        assertEquals ('g', foundUnit.unitNo)
        
        //create a tenant
        def tenant = new Tenant(
            firstName:'brian', 
            lastName:'kurlychek',
            email:'brian.doxsey@yahoo.com',
            phone:'(207) 730-4455',
            creditScore:'800',
            prevAddress:'123 any lane',
            prevLandlord:'chuck norris',
            prevLandlordPhone:'(207) 730-4455',
            comments:'this guy is super cool!'
        )
        //join unit to tenant
        unit.addToTenants(tenant)
        
        assertNotNull tenant.save()
        assertNotNull tenant.lastName
        def foundTenant = Tenant.get(tenant.id)
        assertEquals ('kurlychek', foundTenant.lastName)
    }
    
    void testSaveAndUpdate(){
       def landlord = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull landlord.save()
        //create a property
        def property = new Property(
            address: '16 street', 
            city: 'portland', 
            state:'Maine',
            zipCode:'04102', 
            heating:'oil')
        
        // join landlord to property
        landlord.addToAsset(property)
        
        assertNotNull property.save()
        assertNotNull property.state
        def foundProperty = Property.get(property.id)
        assertEquals ('Maine', foundProperty.state)
        
        def unit = new Unit(
            unitNo:'g',
            sqFeet: '1200',
            //byte[] photo
            description: 'a pretty sweet unit, yo',
            bedrooms:'9',
            status: 'Available'
        )
        
        //join property to a unit
        property.addToUnits(unit)
        
        assertNotNull unit.save()
        assertNotNull unit.unitNo
        def foundUnit = Unit.get(unit.id)
        assertEquals ('g', foundUnit.unitNo)
        
        //create a tenant
        def tenant = new Tenant(
            firstName:'brian', 
            lastName:'kurlychek',
            email:'brian.doxsey@yahoo.com',
            phone:'(207) 730-4455',
            creditScore:'800',
            prevAddress:'123 any lane',
            prevLandlord:'chuck norris',
            prevLandlordPhone:'(207) 730-4455',
            comments:'this guy is super cool!'
        )
        //join unit to tenant
        unit.addToTenants(tenant)
        
        assertNotNull tenant.save()
        
        def foundTen = Tenant.get(tenant.id)
        foundTen.lastName = 'Kurleeeechek'
        foundTen.save()
        
        def editedTen = Tenant.get(tenant.id)
        assertEquals 'Kurleeeechek', editedTen.lastName
    }
    
    void testSaveThenDelete(){
        def landlord = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull landlord.save()
        //create a property
        def property = new Property(
            address: '16 street', 
            city: 'portland', 
            state:'Maine',
            zipCode:'04102', 
            heating:'oil')
        
        // join landlord to property
        landlord.addToAsset(property)
        
        assertNotNull property.save()
        assertNotNull property.state
        def foundProperty = Property.get(property.id)
        assertEquals ('Maine', foundProperty.state)
        
        def unit = new Unit(
            unitNo:'g',
            sqFeet: '1200',
            //byte[] photo
            description: 'a pretty sweet unit, yo',
            bedrooms:'9',
            status: 'Available'
        )
        
        //join property to a unit
        property.addToUnits(unit)
        
        assertNotNull unit.save()
        assertNotNull unit.unitNo
        def foundUnit = Unit.get(unit.id)
        assertEquals ('g', foundUnit.unitNo)
        
        //create a tenant
        def tenant = new Tenant(
            firstName:'brian', 
            lastName:'kurlychek',
            email:'brian.doxsey@yahoo.com',
            phone:'(207) 730-4455',
            creditScore:'800',
            prevAddress:'123 any lane',
            prevLandlord:'chuck norris',
            prevLandlordPhone:'(207) 730-4455',
            comments:'this guy is super cool!'
        )
        //join unit to tenant
        unit.addToTenants(tenant)
        
        assertNotNull tenant.save()
        
         def foundLandlordHavingTen = User.get(landlord.id)
        foundLandlordHavingTen.delete()
        
        //When we delete the landlord a tenant belongs to, the tenant
        //should be deleted as well.
        assertFalse Tenant.exists(tenant.id)
    }
    
    void testIncorrectSave(){
        def landlord = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull landlord.save()
        //create a property
        def property = new Property(
            address: '16 street', 
            city: 'portland', 
            state:'Maine',
            zipCode:'04102', 
            heating:'oil')
        
        // join landlord to property
        landlord.addToAsset(property)
        
        assertNotNull property.save()
        assertNotNull property.state
        def foundProperty = Property.get(property.id)
        assertEquals ('Maine', foundProperty.state)
        
        def unit = new Unit(
            unitNo:'g',
            sqFeet: '1200',
            //byte[] photo
            description: 'a pretty sweet unit, yo',
            bedrooms:'9',
            status: 'Available'
        )
        
        //join property to a unit
        property.addToUnits(unit)
        
        assertNotNull unit.save()
        assertNotNull unit.unitNo
        def foundUnit = Unit.get(unit.id)
        assertEquals ('g', foundUnit.unitNo)
        
        //create a tenant
        def tenant = new Tenant(
            firstName:'brian', 
            lastName:'kurlychek',
            email:'brian.doxsey@yahoo.com',
            phone:'2077304455',
            creditScore:'800',
            prevAddress:'123 any lane',
            prevLandlord:'chuck norris',
            prevLandlordPhone:'(207) 730-4455',
            comments:'this guy is super cool!'
        )
        //join unit to tenant
        unit.addToTenants(tenant)      
        
        assertFalse tenant.validate()
        assertTrue tenant.hasErrors()
        
        def errors = tenant.errors
    
        assertEquals "matches.invalid",
        errors.getFieldError("phone").code
        assertEquals "2077304455",
        errors.getFieldError("phone").rejectedValue
        
    }
    
     void testIncorrectSaveCorrected(){
          def landlord = new User(username: 'angelaloo', firstName: 'angela', 
            lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
        assertNotNull landlord.save()
        //create a property
        def property = new Property(
            address: '16 street', 
            city: 'portland', 
            state:'Maine',
            zipCode:'04102', 
            heating:'oil')
        
        // join landlord to property
        landlord.addToAsset(property)
        
        assertNotNull property.save()
        assertNotNull property.state
        def foundProperty = Property.get(property.id)
        assertEquals ('Maine', foundProperty.state)
        
        def unit = new Unit(
            unitNo:'g',
            sqFeet: '1200',
            //byte[] photo
            description: 'a pretty sweet unit, yo',
            bedrooms:'9',
            status: 'Available'
        )
        
        //join property to a unit
        property.addToUnits(unit)
        
        assertNotNull unit.save()
        assertNotNull unit.unitNo
        def foundUnit = Unit.get(unit.id)
        assertEquals ('g', foundUnit.unitNo)
        
        //create a tenant
        def tenant = new Tenant(
            firstName:'brian', 
            lastName:'kurlychek',
            email:'brian.doxsey@yahoo.com',
            phone:'2077304455',
            creditScore:'800',
            prevAddress:'123 any lane',
            prevLandlord:'chuck norris',
            prevLandlordPhone:'(207) 730-4455',
            comments:'this guy is super cool!'
        )
        //join unit to tenant
        unit.addToTenants(tenant)  
        
        
        assertFalse tenant.validate()
        assertTrue tenant.hasErrors()
        assertNull tenant.save()
        
        tenant.phone = "(203) 740-9877"
        assertTrue(tenant.validate())
        assertFalse(tenant.hasErrors())
        assertNotNull tenant.save()
     }
}
