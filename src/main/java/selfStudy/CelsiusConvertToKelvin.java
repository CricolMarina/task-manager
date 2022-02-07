package selfStudy;

public class CelsiusConvertToKelvin implements BaseConverter{
	
	public double converter(double celsiusToK) {
		double kelvin = celsiusToK + 273.15;
		return kelvin;
	}
}
