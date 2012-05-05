package rent

import org.springframework.dao.DataIntegrityViolationException

class PropertyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def springSecurityService
	
    def currentUser() {
       def user = User.get(springSecurityService.principal.id)       
    } 
	
    def index() {
        redirect(action: "listprop", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [propertyInstanceList: Property.list(params), propertyInstanceTotal: Property.count()]
    }

    def create() {
       
       def user = currentUser()
        [propertyInstance: new Property(params), user: user]
    }

    def save() {
       
        def propertyInstance = new Property(params)
        def user = currentUser()
        propertyInstance.user = user
        if (!propertyInstance.save(flush: true)) {
            render(view: "create", model: [propertyInstance: propertyInstance , user: currentUser()])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'property.label', default: 'Property'), propertyInstance.id])
        redirect(action: "show", id: propertyInstance.id)
    }

    def show() {
        def propertyInstance = Property.get(params.id)
        if (!propertyInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'property.label', default: 'Property'), params.id])
            redirect(action: "list")
            return
        }

        [propertyInstance: propertyInstance]
    }

    def edit() {
        def propertyInstance = Property.get(params.id)
        if (!propertyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'property.label', default: 'Property'), params.id])
            redirect(action: "list")
            return
        }

        [propertyInstance: propertyInstance]
    }

    def update() {
        def propertyInstance = Property.get(params.id)
        if (!propertyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'property.label', default: 'Property'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (propertyInstance.version > version) {
                propertyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'property.label', default: 'Property')] as Object[],
                          "Another user has updated this Property while you were editing")
                render(view: "edit", model: [propertyInstance: propertyInstance])
                return
            }
        }

        propertyInstance.properties = params

        if (!propertyInstance.save(flush: true)) {
            render(view: "edit", model: [propertyInstance: propertyInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'property.label', default: 'Property'), propertyInstance.id])
        redirect(action: "show", id: propertyInstance.id)
    }

    def delete() {
        def propertyInstance = Property.get(params.id)
        if (!propertyInstance) {
		flash.message = message(code: 'default.not.found.message', args: [message(code: 'property.label', default: 'Property'), params.id])
            redirect(action: "list")
            return
        }

        try {
            propertyInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'property.label', default: 'Property'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'property.label', default: 'Property'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
    
       
    def listprop = {
        def user = currentUser()
        [ landlord:user, assetAmt: user.asset.size() ]
    }
}
