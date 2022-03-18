/*
 * Weather.java
 * Tester.java
 * Jerry Hou
 */
import java.util.Scanner;
// Lemonade_Stand class, the class for storing variable and methods such as buy and sell for lemonade stand 
public class Lemonade_Stand {
	
	private Scanner scan = new Scanner(System.in);
	private double money = 20;
	private double price_lemonade = 3;
	private int num_lemonade = 0;
	
	private int num_lemon = 10;
	private int num_suger = 10;
	private int num_ice = 10;
	
	private double lemon_price = 0.15;
	private double suger_price = 0.1;
	private double ice_price = 0.5;

	public Lemonade_Stand() {}
	
	// The process of buying, including some output of the price and current number of lemon
	public void buy(int day, Weather weather) {
			System.out.println(); // some print statesments here
			System.out.println("Day " + day);
			System.out.println("Weather: " + weather.weather_rate + " (0 - 100)");
			System.out.println("You currently have " + num_lemon + " lemons, " + num_suger + " suger, " + num_ice + " ice");
			System.out.println("You have " + money + " dollars");
			
			System.out.println("Price:         Lemon            Suger            Ice");
			System.out.println("               " + lemon_price + "              " + suger_price + "             " + ice_price);
			
			// actually process of buying things, calling the buy_helper method
			num_lemon += buy_helper(lemon_price, "lemons");
			num_suger += buy_helper(suger_price, "sugar");
			num_ice += buy_helper(ice_price, "ice");
			
			System.out.println("\nAfter buying, You have " + num_lemon + " lemons, " + num_suger + " suger, " + num_ice + " ice\n");
						
			// default amount of making lemonade
			System.out.println("You will use default method to make lemonade \n3 lemons, 3 suger, and 3 ice per lemonade\n");
			make_lemonade("Default");
	} // close of buying
	
	// buy helper: buying the amount of a specefic type
	public int buy_helper(double price, String type) {
		System.out.println("You can buy up to " + (int) (money / price) + " " + type);
		System.out.print("How much "+ type +" do you want to buy? ");
		int buy = Integer.parseInt(scan.nextLine());
		money -= buy * price;
		return buy;
	} // close of buy helper
	
	// selling the lemonade
	public void sell(Weather weather) {
		// selling
		System.out.println("\nUse default price " + price_lemonade + " dollars per cup of lemonade");
		System.out.println("Selling...");
		int sell_amount = Math.min(num_lemonade, weather.weather_rate);
		System.out.println("SOLD " + sell_amount + " CUPS OF LEMONADE");
		System.out.println("PROFIT: " + (sell_amount * price_lemonade));
		money += sell_amount * price_lemonade;
		System.out.println("CURRENT MONEY: " + money);
		num_lemonade -= sell_amount;
		// get rid of ice melt and bad lemonade at the end of the day
		System.out.println(num_ice + " ice melted");
		num_ice = 0;
		System.out.println((num_lemonade * 3 / 4) + " can not keep to the next day");
		num_lemonade = num_lemonade / 4;
	} // close of selling lemonade
	
	// make lemonade enter how the user choice, default method or their own method
	public void make_lemonade(String user_choice) {
		if (user_choice.equals("Default")) {
			// defaut method of making, using lemonade helper to make
			make_lemonade_helper(3, 3, 3);
		} else {
			System.out.print("Lemon in recipe: ");
			int l = Integer.parseInt(scan.nextLine());
			System.out.print("Suger in recipe: ");
			int s = Integer.parseInt(scan.nextLine());
			System.out.print("ice in recipe: ");
			int i = Integer.parseInt(scan.nextLine());
			// user's method of making, using lemonade helper to make
			make_lemonade_helper(l, s, i);
		}
	} // close of make_lemonade
	
	// make_lemonade_helper: using l of lemon, s of sugar, i of ice to one lemonade, see how much can make
	public void make_lemonade_helper(int l, int s, int i) {
		while (num_lemon >= l && num_suger >= s && num_ice >= i) {
			num_lemonade ++;
			num_lemon -= l;
			num_suger -= s;
			num_ice -= i;
		}
		System.out.println("Making Lemonade...");
		System.out.println("After making, you have " + num_lemon + " lemons, " + num_suger + " suger, " + num_ice + " ice\n");
		System.out.println("You have " + num_lemonade + " cups of lemonade");
	} // close of make_lemonade_helper
} // close of Lemonade_Stand class
