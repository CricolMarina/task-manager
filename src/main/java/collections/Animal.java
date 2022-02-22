package collections;

public class  Animal {
	
	private String gender;
	private String name;
	private int age;
	private boolean isVaccinated;
	
	public Animal(String gender, String name, int age, boolean isVaccinated) {
		this.gender = gender;
		this.name = name;
		this.age = age;
		this.isVaccinated = isVaccinated;
	}
	
	public Animal() {}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isVaccinated() {
		return isVaccinated;
	}

	@Override
	public String toString() {
		return "Animal [gender=" + gender + ", name=" + name + ", age=" + age + ", isVaccinated=" + isVaccinated + "]";
	}
	
	@Override
	public boolean equals(Object object) {
		boolean isEqual = false;
		if(this.getGender()==((Animal) object).getGender() 
				&& this.getName() == ((Animal) object).getName()
				&& this.getAge() == ((Animal) object).getAge()
				&& this.isVaccinated() == ((Animal) object).isVaccinated()) {
			isEqual = true;
		}
		return isEqual;
	}
}
