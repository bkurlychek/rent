package rent

class User extends SecUser{

    String firstName
    String lastName
    String email
    Date dateCreated
    String phone   
    
    
    static constraints = {
        
        firstName( blank: false, size: 1..20)
        lastName( blank:false,)
        email(email:true, blank: false)
        
        phone(blank:false,matches:/^\([1-9]\d{2}\)\s?\d{3}\-\d{4}$/)
        dateCreated()
        
    }
    
    static hasMany =[asset:Property]
    
    String toString(){
        "${firstName} ${lastName}"
    }
    
}
