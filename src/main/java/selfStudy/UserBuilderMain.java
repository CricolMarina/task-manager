package selfStudy;

import java.util.ArrayList;
import java.util.List;

public class UserBuilderMain {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		User user_1 = new User.Builder()
				.setFirstName("John")
				.setLastName("Smith")
				.setAge(29)
				.setAddress("New York, 20435")
				.setEmail("jsmith@gmail.com")
				.build();
		
		User user_2 = new User.Builder()
				.setFirstName("Kate")
				.setLastName("Hamilton")
				.setAge(32)
				.setAddress("Paris, 16f")
				.setEmail("kate_hamilton@gmail.com")
				.build();
		
		User user_3 = new User.Builder()
				.setFirstName("Denis")
				.setLastName("Popov")
				.setAge(41)
				.setAddress("Chisinau, 2075")
				.setEmail("den_popov@yahoo.com")
				.build();
		
		User user_4 = new User.Builder()
				.setFirstName("Olga")
				.setLastName("Munteanu")
				.setAge(18)
				.setAddress("Bucharest, 20B")
				.setEmail("munteanu_o@yahoo.com")
				.build();
		
		userList.add(user_1);
		userList.add(user_2);
		userList.add(user_3);
		userList.add(user_4);
	}
}
