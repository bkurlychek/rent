package rent



import org.junit.*
import grails.test.mixin.*

@TestFor(UnitController)
@Mock(Unit)
class UnitControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/unit/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.unitInstanceList.size() == 0
        assert model.unitInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.unitInstance != null
    }

    void testSave() {
        controller.save()

        assert model.unitInstance != null
        assert view == '/unit/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/unit/show/1'
        assert controller.flash.message != null
        assert Unit.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/unit/list'


        populateValidParams(params)
        def unit = new Unit(params)

        assert unit.save() != null

        params.id = unit.id

        def model = controller.show()

        assert model.unitInstance == unit
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/unit/list'


        populateValidParams(params)
        def unit = new Unit(params)

        assert unit.save() != null

        params.id = unit.id

        def model = controller.edit()

        assert model.unitInstance == unit
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/unit/list'

        response.reset()


        populateValidParams(params)
        def unit = new Unit(params)

        assert unit.save() != null

        // test invalid parameters in update
        params.id = unit.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/unit/edit"
        assert model.unitInstance != null

        unit.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/unit/show/$unit.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        unit.clearErrors()

        populateValidParams(params)
        params.id = unit.id
        params.version = -1
        controller.update()

        assert view == "/unit/edit"
        assert model.unitInstance != null
        assert model.unitInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/unit/list'

        response.reset()

        populateValidParams(params)
        def unit = new Unit(params)

        assert unit.save() != null
        assert Unit.count() == 1

        params.id = unit.id

        controller.delete()

        assert Unit.count() == 0
        assert Unit.get(unit.id) == null
        assert response.redirectedUrl == '/unit/list'
    }
}
