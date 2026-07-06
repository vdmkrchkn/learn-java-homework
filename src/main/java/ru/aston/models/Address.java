package ru.aston.models;

public class Address implements IAddress {
	private String city;
	
	public Address(String city) {
		this.city = city;
	}

	@Override
	public Address clone() {
		if (city == null) {
            try {
                return (Address)super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
		return new Address(city);
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
