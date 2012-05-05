package rent

class PropertyService {

	boolean transactional = false
	def getStaticProp() {
		return new Property(address: "5 sydney way", city: "portland", state: "maine", zipCode: "04102", heating: "oil")

	}
	def getRandomProp() {
		def allProps = Property.list()
		def randomProp = null
		if (allProps.size() > 0) {
			def randomIdx = new Random().nextInt(allProps.size())
			randomProp = allProps[randomIdx]
		} else {
			randomProp = getStaticProp()
		}
		return randomProp
	}
}
