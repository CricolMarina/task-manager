package selfStudy;

public class User {
	
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;
	private String email;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public static class Builder{
		private User user;
		
		public Builder() {
			user = new User();
		}
		
		public Builder setFirstName(String firstName) {
			user.firstName = firstName;
			return this;
		}
		
		public Builder setLastName(String lastName) {
			user.lastName = lastName;
			return this;
		}
		
		public Builder setAge(int age) {
			user.age = age;
			return this;
		}
		
		public Builder setPhone(String phone) {
			user.phone = phone;
			return this;
		}
		
		public Builder setAddress(String address) {
			user.address = address;
			return this;
		}
		
		public Builder setEmail(String email) {
			user.email = email;
			return this;
		}
		
		public User build() {
			return user;
		}
	}
}
