package rent



import org.junit.*
import grails.test.mixin.*

@TestFor(PropertyController)
@Mock(Property)
class PropertyControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/property/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.propertyInstanceList.size() == 0
        assert model.propertyInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.propertyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.propertyInstance != null
        assert view == '/property/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/property/show/1'
        assert controller.flash.message != null
        assert Property.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/property/list'


        populateValidParams(params)
        def property = new Property(params)

        assert property.save() != null

        params.id = property.id

        def model = controller.show()

        assert model.propertyInstance == property
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/property/list'


        populateValidParams(params)
        def property = new Property(params)

        assert property.save() != null

        params.id = property.id

        def model = controller.edit()

        assert model.propertyInstance == property
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/property/list'

        response.reset()


        populateValidParams(params)
        def property = new Property(params)

        assert property.save() != null

        // test invalid parameters in update
        params.id = property.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/property/edit"
        assert model.propertyInstance != null

        property.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/property/show/$property.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        property.clearErrors()

        populateValidParams(params)
        params.id = property.id
        params.version = -1
        controller.update()

        assert view == "/property/edit"
        assert model.propertyInstance != null
        assert model.propertyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/property/list'

        response.reset()

        populateValidParams(params)
        def property = new Property(params)

        assert property.save() != null
        assert Property.count() == 1

        params.id = property.id

        controller.delete()

        assert Property.count() == 0
        assert Property.get(property.id) == null
        assert response.redirectedUrl == '/property/list'
    }
}
