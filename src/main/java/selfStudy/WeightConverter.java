package selfStudy;

import java.util.Scanner;

public class WeightConverter implements UnitConverter {
	
	private double kilogram ;
	private double gram ;
	private double lb ;
	private double carat ;
	
	@Override
	public String toString() {
		return "WeightConverter [kilogram = " + kilogram + " , gram = " + gram + ", lb = " + lb + ", carat = " + carat + "]";
	}

	public void convertTo() {
		System.out.println("Please introduce the weight you want to convert : ");
		Scanner weightScanner = new Scanner(System.in);
		double unit = weightScanner.nextDouble();
		kilogram = unit ;
		gram = kilogram*1000;
		lb = kilogram*2.205;
		carat = kilogram * 5000;
		System.out.println(toString());
	}
}
