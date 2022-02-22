package collections;

import java.util.ArrayList;
import java.util.List;

public class Main {


	public static void main(String[] args) {
		FindDuplicates findDuplicates = new FindDuplicatesImpl();
		List<Animal> animals = new ArrayList<Animal>();
		Animal cat = new Cat("F", "Kitty", 2, true);
		Animal dog = new Dog("M", "Arrchy", 4, false);
		Animal cat1 = new Cat("F", "Kitty", 2, true);
		Animal cat2 = new Cat("F", "Kitty", 2, true);
		Animal hamster = new Hamster("F", "Mickey", 1, false);
		Animal dog1 = new Dog("M", "Arrchy", 4, false);
		Animal hamster1 = new Hamster("F", "Mickey", 1, false);
		Animal hamster2 = new Hamster("F", "Mickey-Mouse", 3, true);
		
		animals.add(cat);
		animals.add(dog1);
		animals.add(cat1);
		animals.add(hamster);
		animals.add(hamster1);
		animals.add(dog);
		animals.add(cat2);
		animals.add(hamster2);

		
		System.out.println(findDuplicates.findDuplicates(animals));
	}
}
