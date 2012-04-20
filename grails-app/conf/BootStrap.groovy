import rent.*

class BootStrap {

    def springSecurityService
    
    def init = { servletContext ->
        
        def springSecurityService
        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
       
        
        def brian = User.findByUsername('brian') ?: new User (
            username: 'brian',
            firstName:'brian', 
            lastName:'kurlychek',
            password: 'none1234',
            enabled: true,
            dateCreated: new Date(),
            email:'brian.kurlychek@maine.edu',
            phone:'(207)216-3822'
        ).save()


        if (!brian.authorities.contains(userRole)) {
            SecUserSecRole.create brian, userRole
        }
        
        
        def quad = User.findByUsername('quad') ?: new User (
            username: 'quad',
            firstName:'q', 
            lastName:'yaqub',
            password: 'none1234',
            dateCreated: new Date(),
            enabled: true,
            email:'none@none.com',
            phone:'(207)215-3522'
        ).save()
        

        if (!quad.authorities.contains(userRole)) {
            SecUserSecRole.create quad, userRole
        }


        def angela = User.findByUsername('angela') ?: new User (
            username: 'angela',
            firstName:'angela', 
            lastName:'doxsey',
            password: 'none1234',
            dateCreated: new Date(),
            enabled: true,
            email:'dox@dox.com',
            phone:'(200)664-3456'
        ).save()   


        if (!angela.authorities.contains(userRole)) {
            SecUserSecRole.create angela, userRole
        }

            def admin = User.findByUsername('admin') ?: new User (
            username: 'admin',
            firstName:'admin', 
            lastName:'admin',
            password: 'none1234',
            dateCreated: new Date(),
            enabled: true,
            email:'dox@dox.com',
            phone:'(200)664-3456'
        ).save()   


        if (!admin.authorities.contains(adminRole)) {
            SecUserSecRole.create admin, adminRole
        }



    }
    def destroy = {
    }
}
