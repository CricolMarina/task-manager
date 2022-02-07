package selfStudy;

public class CelsiusConverterToFahrenheit implements BaseConverter {
	
	public double converter(double celsiusToF) {
		double fahrenheit = (celsiusToF * 9/5) + 32;
		return fahrenheit;
	}
}
