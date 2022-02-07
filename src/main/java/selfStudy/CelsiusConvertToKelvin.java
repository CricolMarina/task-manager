package selfStudy;

public class CelsiusConvertToKelvin implements BaseConverter{
	private static final double KELVIN_CONSTANT=273.15;
	
	public double converter(double celsiusToK) {
		double kelvin=celsiusToK + KELVIN_CONSTANT;
		return kelvin;
	}
}
