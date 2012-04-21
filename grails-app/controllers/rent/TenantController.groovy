package rent

class TenantController {

     static scaffold = true;    
     def index={ redirect(action:'list') }
}
