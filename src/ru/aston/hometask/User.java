package ru.aston.hometask;

public final class User {
	private final String name;
	private final Address address;
	
	public User(String name, Address address) {
		this.name = name;
		this.address = address.clone();
	}
	
	String getName() {
		return name;
	}
	
	Address getAddress() {
		return address.clone();
	}

	@Override
	public String toString() {
		return getName() + " from " + address.getCity();
	}
}
