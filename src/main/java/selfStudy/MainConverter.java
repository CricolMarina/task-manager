package selfStudy;

import java.util.Scanner;

public class MainConverter {

	public static void main(String[] args) {
		UnitConverter converter = null;
		
		System.out.println("Please select type of converter : " + '\n' +
				"1. distance" + '\n' +
				"2. weight");
		
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		if (1==choice) {
			converter = new DistanceConverter();
		} else if (2==choice){
			converter = new WeightConverter();
		}
		converter.convertTo();
		printMessage(converter);
	}
	
	public static void printMessage(UnitConverter unitConverter) {
		System.out.println(unitConverter.toString());
	}
}
