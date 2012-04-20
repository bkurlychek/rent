package rent

class Unit {
String unitNo
    int sqFeet
    String description
    int bedrooms
    String status
    
    
    static constraints = {
        unitNo(blank: false, matches: '^[0-9a-zA-Z]{1,5}\$')
        sqFeet(nullable: true, matches: '^[0-9]{1,5}\$')
        description(maxSize:1000, blank:true)
        bedrooms(inList: [1, 2, 3, 4, 5, 6, 7, 8, 9], blank: false) 
        status(inList: ["Available","Rented"])
    }
    
    static belongsTo = [property: Property]
    static hasMany = [tenants: Tenant]
    
    String toString(){
        "Unit: ${unitNo} "
    }
}
