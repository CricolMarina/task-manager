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
			distanceConverter.convertTo();
		} else if (2==choice){
			weighConverter.convertTo();
		}
	}
}
