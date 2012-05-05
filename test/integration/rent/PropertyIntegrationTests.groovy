package rent

import static org.junit.Assert.*
import org.junit.*

class PropertyIntegrationTests {
	void testSave(){
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
	}

	void testSaveAndUpdate(){
		def landlord = new User(username: 'angelaloo', firstName: 'angela',
				lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
		assertNotNull landlord.save()
		def property = new Property(
				address: '16 street',
				city: 'portland',
				state:'Maine',
				zipCode:'04102',
				heating:'oil')

		// join landlord to property
		landlord.addToAsset(property)
		assertNotNull property.save()

		def foundProp = Property.get(property.id)
		foundProp.state = 'Alabama'
		foundProp.save()

		def editedProp = Property.get(property.id)
		assertEquals 'Alabama', editedProp.state
	}

	void testSaveThenDelete(){
		def landlord = new User(username: 'angelaloo', firstName: 'angela',
				lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
		assertNotNull landlord.save()

		def property = new Property(
				address: '16 street',
				city: 'portland',
				state:'Maine',
				zipCode:'04102',
				heating:'oil')

		// join landlord to property
		landlord.addToAsset(property)
		assertNotNull property.save()

		def foundLandHavingProp = User.get(landlord.id)
		foundLandHavingProp.delete()

		//When we delete the landlord a property belongs to, the property
		//should be deleted as well.
		assertFalse Property.exists(property.id)
	}

	void testIncorrectSave(){
		def landlord = new User(username: 'angelaloo', firstName: 'angela',
				lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
		assertNotNull landlord.save()

		def property = new Property(
				address: '16 street',
				city: 'portland',
				state:'meeeee',
				zipCode:'04102',
				heating:'oil')

		// join landlord to property
		landlord.addToAsset(property)

		assertFalse property.validate()
		assertTrue property.hasErrors()

		def errors = property.errors

		assertEquals "not.inList",
				errors.getFieldError("state").code
		assertEquals "meeeee",
				errors.getFieldError("state").rejectedValue

	}
	void testIncorrectSaveCorrected(){
		def landlord = new User(username: 'angelaloo', firstName: 'angela',
				lastName:'doxsey',email:'angela.doxsey@yahoo.com', password:'heyman',phone:'(207) 730-4455')
		assertNotNull landlord.save()

		def property = new Property(
				address: '16 street',
				city: 'portland',
				state:'meeeee',
				zipCode:'04102',
				heating:'oil')

		// join landlord to property
		landlord.addToAsset(property)

		assertFalse (property.validate())
		assertTrue (property.hasErrors())
		assertNull property.save()

		property.state = "Maine"
		assertTrue(property.validate())
		assertFalse(property.hasErrors())
		assertNotNull property.save()
	}
}
