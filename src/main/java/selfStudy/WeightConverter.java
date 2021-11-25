package selfStudy;

public class WeightConverter implements UnitConverter {
	
	private double kilogram ;
	private double gram ;
	private double lb ;
	private double carat ;
	
	@Override
	public String toString() {
		return "WeightConverter [kilogram = " + kilogram + " , gram = " + gram + ", lb = " + lb + ", carat = " + carat + "]";
	}

	public void convertTo(double unit) {
		kilogram = unit ;
		gram = kilogram*1000;
		lb = kilogram*2.205;
		carat = kilogram * 5000;
		System.out.println(toString());
	}
}
