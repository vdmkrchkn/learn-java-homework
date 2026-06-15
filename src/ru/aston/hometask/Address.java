package ru.aston.hometask;

public class Address implements Cloneable {
	private String city;
	
	public Address(String city) {
		this.city = city;
	}

	@Override
	protected Address clone() {
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
