package module1;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Как вас зовут? ");
		String name = in.nextLine();
		System.out.print("Из какого города? ");
		String city = in.nextLine();
		in.close();
		ImmutableHello iHello = new ImmutableHello(name, city);
		System.out.println(iHello.toString());		
	}

}
