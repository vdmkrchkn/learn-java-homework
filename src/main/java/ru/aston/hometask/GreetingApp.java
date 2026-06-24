import java.util.Scanner;

public class GreetingApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Как вас зовут? ");
		String name = in.nextLine();
		System.out.print("Из какого города? ");
		String city = in.nextLine();
		in.close();

		User user = new User(name, new Address(city));
		IAddress newAddress = user.getAddress();
		newAddress.setCity("Moscow");
		System.out.println("Hello, " + user + "!");
	}

}
