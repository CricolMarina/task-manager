package selfStudy;

public class CelsiusConverterToFahrenheit implements BaseConverter {
	private static final double FAHRENHEIT_CONSTANT = 32;
	
	public double converter(double celsiusToF) {
		double fahrenheit = (celsiusToF * 9/5) + FAHRENHEIT_CONSTANT;
		return fahrenheit;
	}
}
