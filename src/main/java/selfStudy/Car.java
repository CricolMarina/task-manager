package selfStudy;

public class Car {
	
	private String brand;
	private String color;
	private String carBody;
	private int year;
	private int doorNr;
	private String gasType;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCarBody() {
		return carBody;
	}
	public void setCarBody(String carBody) {
		this.carBody = carBody;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDoorNr() {
		return doorNr;
	}
	public void setDoorNr(int doorNr) {
		this.doorNr = doorNr;
	}
	public String getGasType() {
		return gasType;
	}
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	
	public static class Builder{
		
		private Car newCar;
		
		public Builder() {
			newCar = new Car();
		}
		
		public Builder withBrand(String brand) {
			newCar.brand = brand;
			return this;
		}
		
		public Builder withColor(String color) {
			newCar.color = color;
			return this;
		}
		
		public Builder withCarBody(String carBody) {
			newCar.carBody = carBody;
			return this;
		}
		
		public Builder withYear(int year) {
			newCar.year = year;
			return this;
		}
		
		public Builder withDoorNr(int doorNr) {
			newCar.doorNr = doorNr;
			return this;
		}
		
		public Builder withGasType(String gasType) {
			newCar.gasType = gasType;
			return this;
		}
		
		public Car build() {
			return newCar;
		}
	}

}
