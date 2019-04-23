package xyz.foobar.test;


import java.io.Serializable;
import java.util.Set;

public class Person implements Serializable {

	private static final long serialVersionUID = -4309657210316182163L;

	private String firstName;
	private String surname;
	private Person friend;
	private Pet pet;
	private Set<String> nickNames;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Person getFriend() {
		return friend;
	}
	
	public void setFriend(Person friend) {
		this.friend = friend;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Set<String> getNickNames() {
		return nickNames;
	}
	
	public void setNickNames(Set<String> nickNames) {
		this.nickNames = nickNames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		result = prime * result
				+ ((nickNames == null) ? 0 : nickNames.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (nickNames == null) {
			if (other.nickNames != null)
				return false;
		} else if (!nickNames.equals(other.nickNames))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", surname='" + surname + '\'' +
				", friend=" + friend +
				", nickNames=" + nickNames +
				'}';
	}
}
