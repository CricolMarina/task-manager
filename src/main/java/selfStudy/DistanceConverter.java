package selfStudy;

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

	public void convertTo(double unit) {
		meter = unit;
		kilometer = meter/1000;
		yard = meter*1.094;
		foot = meter*3.281;
		System.out.println(toString());
	}
}
