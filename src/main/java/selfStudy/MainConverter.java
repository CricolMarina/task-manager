package selfStudy;

import java.util.Scanner;

public class MainConverter {

	public static void main(String[] args) {
		UnitConverter weighConverter = new WeightConverter();
		UnitConverter distanceConverter = new DistanceConverter();
		
		System.out.println("Please select type of converter : " + '\n' +
				"1. distance" + '\n' +
				"2. weight");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (1==choice) {
			System.out.println("Please introduce the distance you want to convert : ");
			Scanner distanceScanner = new Scanner(System.in);
			double distanceUnit = distanceScanner.nextDouble();
			distanceConverter.convertTo(distanceUnit);
		} else if (2==choice){
			System.out.println("Please introduce the weight you want to convert : ");
			Scanner weightScanner = new Scanner(System.in);
			double weightUnit = weightScanner.nextDouble();
			weighConverter.convertTo(weightUnit);
		}
	}
}
