class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		//"500"(view:'/error')
		"500"(view: "/500error")
		"404"(view:"404error")

		"/login/$action?"(controller: "login")
		"/logout/$action?"(controller: "logout")
		
		"/propertyrest/"(controller: "propertyRest"){
			action = [GET: "list", POST: "save"]
		}
		"/propertyrest/show/$id"(controller: "propertyRest"){
			action = [GET: "show"]
		}
		
	}
}
