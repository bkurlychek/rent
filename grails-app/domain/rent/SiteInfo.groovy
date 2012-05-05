package rent

class SiteInfo {

	String email
	String name
	String comments

	static constraints = {
		email(email:true, blank: false)
		name(blank: false)
		comments(blank: false)
	}
}

