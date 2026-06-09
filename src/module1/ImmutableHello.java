package module1;

public final class ImmutableHello {
	private final String name;
	private final Adress adress;
	
	public ImmutableHello(String name, String adress) {
		this.name = name;
		this.adress = new Adress(adress);
	}
	
	String getName() {
		return name;
	}
	
	String getAdress() {
		return this.adress.getCity();
	}

	@Override
	public String toString() {
		return "Hello, " + getName() + " from " + getAdress() + "!";
	}
}
