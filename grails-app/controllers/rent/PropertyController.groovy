package rent
import grails.plugins.springsecurity.Secured

class PropertyController {

    def scaffold = true
    
    def index={ 
       redirect(action: 'list') }
	
   
    def listprop = {
        def user = User.findByUserId(params.id)
        [ user:user, assetAmt: user.asset.size() ]
    }
}
