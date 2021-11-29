package selfStudy;

import java.util.Scanner;

public class DistanceConverter implements UnitConverter{
	
	private double meter ;
	private double kilometer ;
	private double yard ;
	private double foot ;
	
	@Override
	public String toString() {
		return "DistanceConverter [meter=" + meter + ", kilometer=" + kilometer + ", yard=" + yard + ", foot=" + foot
				+ "]";
	}

	public void convertTo() {
		System.out.println("Please introduce the distance you want to convert : ");
		Scanner distanceScanner = new Scanner(System.in);
		double unit = distanceScanner.nextDouble();
		meter = unit;
		kilometer = meter/1000;
		yard = meter*1.094;
		foot = meter*3.281;
	}
}
