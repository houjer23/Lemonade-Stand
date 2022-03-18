/*
 * Tester.java
 * Lemonade_Stand.java
 * Jerry Hou
 */
public class Weather {
	int weather_rate;
	int lowest;
	int highest;
	int num_costomers;
	// Weather class determine the amount of people coming in
	public Weather() {
		weather_rate = (int) (Math.random() * 90 + 5);
		lowest = weather_rate - 5;
		highest = weather_rate + 5;
		num_costomers = (int) (Math.random() * (highest - lowest) + lowest) / 5; // argorithm to determine the amount of people
	}
}
