/*
 * Weather.java
 * Lemonade_Stand.java
 * Jerry Hou
 */
import java.util.Scanner;
// Tester class, the class for calling other classes
public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Lemonade_Stand myStand = new Lemonade_Stand();
		System.out.print("\nDO YOU WANT TO CONTINUE (ENTER 'Y' or 'N') ");
		char next = scan.nextLine().charAt(0);
		int day = 1;
		// loop each day
		while (next == 'Y') {
			Weather weather = new Weather();
			// buy & make lemonade
			myStand.buy(day, weather);
			System.out.print("ENTER TO CONTINUE ");
			scan.nextLine();
			// sell lemonade
			myStand.sell(weather);
			// check if continues
			System.out.print("\nDO YOU WANT TO CONTINUE (ENTER 'Y' or 'N') ");
			next = scan.nextLine().charAt(0);
			System.out.println("\n---------------------------------------------\n");
			day ++;
		}
	} // close of public static void main
} // close of Tester class
