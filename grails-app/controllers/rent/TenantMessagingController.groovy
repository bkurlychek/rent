package rent

class TenantMessagingController {

	def springSecurityService
	def tMess
	def tAddress
	ArrayList<String> ems = new ArrayList<String>()
	ArrayList<Unit> uns = new ArrayList<Unit>()
	ArrayList<Tenant> tenans = new ArrayList<Tenant>()

	def success = {
		session.tAddress = null
		session.tenans = null
	}

	def failure = {}

	def plist = {
		if(!params.plist){
			return
		}

		if (params.plist){
			tMess = new TenantMessaging(address: params.address,
					content: "None yet")

			if(tMess.validate()){
				tMess.save()
				boolean found = false
				def addr = params.address
				def proplist = Property.list()
				for	(Property prop: proplist){
					if (prop.address == addr){
						found = true
						tAddress = addr
					}
				}
				if (found == false){
					flash.message = "tUp.invalid.message"
					return
				}
				
				if (tAddress){
					def property=Property.findByAddress(tAddress)
					//if(property.size()==0)
					for(Unit uni: property.units)
						uns.push(uni)
					println uns
					int uSize = uns.size()
					if (uSize){
						for (int i=0; i<uSize; i++){
							def un = uns.getAt(i)
							tenans.push(un.tenants)
							println tenans
						}
					}

					session.tAddress = tAddress
					session.tenans = tenans
				}
				redirect(action: "send")//, [tenans: tenans])
			}

			[tMess: tMess]//, tenans: tenans]
		}

	}

	def send = {
		if(!params.send){
			return
		}

		if (params.send){
			println params.tAddress
			tMess = new TenantMessaging(address: "fake address",
					content: params.content)

			println params.tAddress

			if (tMess.validate()){
				if (params.tAddress){
					def property=Property.findByAddress(params.tAddress)
					for(Unit uni: property.units)
						uns.push(uni)
					println uns
					int uSize = uns.size()
					if (uSize){
						for (int i=0; i<uSize; i++){
							def un = uns.getAt(i)
							tenans.push(un.tenants)
							println tenans
						}
					}

					String ems = ""
					for (int i=0; i<tenans.size(); i++){
						def t = tenans.getAt(i)
						sendMail {
							to t.email
							from "happyllapp@gmail.com"
							subject "New message from your landlord"
							html '<br> Message contains the following:  <br>' + tMess.content
						}
					}

					redirect(action: "success")
					[tMess: tMess]
				}

			}
		}
	}
}
