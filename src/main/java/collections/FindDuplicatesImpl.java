package collections;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesImpl implements FindDuplicates {

	public List<Animal> findDuplicates(List<Animal> animalList) {
		List<Animal> listWithoutDuplicates = new ArrayList<Animal>();
		listWithoutDuplicates.add(animalList.get(0));
		int j = 0;
		for (int i=0; i<animalList.size(); i++) {
			if(!listWithoutDuplicates.contains(animalList.get(i))) {
				listWithoutDuplicates.add(animalList.get(i));
				j++;
			} 
		}
		return listWithoutDuplicates;
	}
}