package module1;

public final class ImmutableHello {
	private final String name;
	private final Address address;
	
	public ImmutableHello(String name, Address address) {
		this.name = name;
		this.address = new Address(address.getCity());
	}
	
	String getName() {
		return name;
	}
	
	Address getAddress() {
		return new Address(address.getCity());
	}

	@Override
	public String toString() {
		return "Hello, " + getName() + " from " + address.getCity() + "!";
	}
}
