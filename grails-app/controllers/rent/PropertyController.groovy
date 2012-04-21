package rent
import grails.plugins.springsecurity.Secured

class PropertyController {
    def springSecurityService
    
    def scaffold = true
    
    def index={ 
       redirect(action: 'list') }
	
   
    def listprop = {
        def user = User.get(springSecurityService.principal.id)
        [ landlord:user, assetAmt: user.asset.size() ]
    }
}
