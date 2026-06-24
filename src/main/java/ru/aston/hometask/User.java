public final class User {
	private final String name;
	private final IAddress address;
	
	public User(String name, IAddress address) {
		this.name = name;
		this.address = address.clone();
	}
	
	String getName() {
		return name;
	}
	
	IAddress getAddress() {
		return address.clone();
	}

	@Override
	public String toString() {
		return getName() + " from " + address.getCity();
	}
}
