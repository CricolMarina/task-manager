package selfStudy;

public class CarBuilderMain {
	
	public static void main(String [] args) {
		
		Car car1 = new Car.Builder()
				.withColor("red")
				.withGasType("gas")
				.withBrand("Lexus")
				.build();
		
		Car car2 = new Car.Builder()
				.withBrand("Mercedes")
				.withYear(2021)
				.withDoorNr(3)
				.build();
	}

}
