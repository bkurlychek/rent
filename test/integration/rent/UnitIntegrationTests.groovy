package rent

import static org.junit.Assert.*
import org.junit.*

class UnitIntegrationTests {
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
	}

	void testSaveAndUpdate(){
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
				description: 'a pretty sweet unit, yo',
				bedrooms:'9',
				status: 'Available'
				)
		//join property to a unit
		property.addToUnits(unit)
		assertNotNull unit.save()

		def foundUnit = Unit.get(unit.id)
		foundUnit.status = 'Rented'
		foundUnit.save()

		def editedUnit = Unit.get(unit.id)
		assertEquals 'Rented', editedUnit.status
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
				description: 'a pretty sweet unit, yo',
				bedrooms:'9',
				status: 'Available'
				)
		//join property to a unit
		property.addToUnits(unit)
		assertNotNull unit.save()


		def foundLandlordHavingUnit = User.get(landlord.id)
		foundLandlordHavingUnit.delete()

		//When we delete the landlord a unit belongs to, the unit
		//should be deleted as well.
		assertFalse Unit.exists(unit.id)
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
				description: 'a pretty sweet unit, yo',
				bedrooms:'9',
				status: 'Empty'
				)
		//join property to a unit
		property.addToUnits(unit)

		assertFalse unit.validate()
		assertTrue unit.hasErrors()

		def errors = unit.errors

		assertEquals "not.inList",
				errors.getFieldError("status").code
		assertEquals "Empty",
				errors.getFieldError("status").rejectedValue
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
				description: 'a pretty sweet unit, yo',
				bedrooms:'9',
				status: 'Empty'
				)
		//join property to a unit
		property.addToUnits(unit)

		assertFalse unit.validate()
		assertTrue unit.hasErrors()
		assertNull unit.save()

		unit.status = "Rented"
		assertTrue(unit.validate())
		assertFalse(unit.hasErrors())
		assertNotNull unit.save()
	}
}
