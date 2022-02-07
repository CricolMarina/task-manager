package selfStudy;

public class MainBaseConverter {
	
	public static void main (String[] args) {

		BaseConverter celsiusToF = new CelsiusConverterToFahrenheit();
		BaseConverter celsiusToK = new CelsiusConvertToKelvin();
		System.out.println(celsiusToF.converter(4) + "F");
		System.out.println(celsiusToK.converter(6) + "K");
	}
}
