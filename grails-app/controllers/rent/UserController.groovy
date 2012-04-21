package rent
import grails.plugins.springsecurity.Secured

class UserController {

    def scaffold = true
 
    def springSecurityService

    def index= {
      redirect(action:'list')
        
    }
   
    def register= {
        if (!params.register) return
        
        if (params) {
            
            def user = new User(
            username: params.username,
            firstName: params.firstName, 
            lastName: params.lastName,
            password: params.password,
            enabled: true,
            dateCreated: new Date(),
            email: params.email,
            phone: params.phone
            )
                                     
            if (user.validate()) {
                user.save()
                flash.message = "Successfully Created User"
                
                sendMail {
                    to params.email /// to where it should go. we should get the email from param
                    from "Qyaqub@happLandLord.com" ///  not really cool
                    subject "Welcome to happy landlord!" 
                    html '<table> <tr> <td > Dear' + " ${params.firstName}:" + 
                    ' </td></tr><tr><td> <br><p>Thank you for registering with Happy Landlord! :)<br><br><br> The Happy Landlord Team - ABQ - </p> </td></tr></table> '
                    
                }
                ////////////////////
                def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)

               
                
                
                if (!user.authorities.contains(userRole)) {
                    SecUserSecRole.create user, userRole
                }
                                
                /////////////////////
                
                redirect (controller: 'login', action: 'index' ) 
            }else{
                flash.message = "Error Registering User"
                [ user: user ] 
            }

        }else{
            [user: user]
        }  
    }
    
    def aboutus = {}
    
    def login = {}
  
    def authenticate = {
        def user = User.findByUserId(params.userId)
        if(user){
            def  props = Property.getAll()
                           
            session.user = user           
            flash.message = "Hello ${user.firstName}!"
            redirect(controller:"property",action:"listprop", params: [id:session.user.userId])
              
        }else{
            flash.message = "Sorry, ${params.userId}. Please try again."
            redirect(uri:"/")
        }
    }
  
    def logout = {
        flash.message = "Goodbye ${session.user.firstName}"
        session.user = null
        redirect(uri: "/")      
    }  
}