package rent

class TenantMessaging {

	String address
	String content
	
    static constraints = {
		address(blank: false)
		content(blank: false)
    }
}
