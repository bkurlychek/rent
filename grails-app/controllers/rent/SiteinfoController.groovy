package com.happyl

class SiteinfoController {
    //def home = {}
    def aboutus = {}
    def contactus = {}    
    def privacy = {}  
    
    def propertyService
    
    def home = {
        def randomProp = propertyService.getRandomProp()
        [ prop : randomProp ]
        redirect(uri: "/", props)
    }
    def ajaxRandom = {
        def randomProp = propertyService.getRandomProp()
            render "<p> Address: ${randomProp.address}</p>" + 
                   "<p> City: ${randomProp.city}</p>" +
                   "<p> State: ${randomProp.state}</p>" +
                   "<p> Zip Code: ${randomProp.zipCode}</p>" +
                   "<p> Heating: ${randomProp.heating}</p>"
   }
}

