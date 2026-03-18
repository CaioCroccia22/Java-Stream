package dao;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonDAO implements IObjectDAO<Person> {
	
	public static List<Person> list = new ArrayList<Person>();

	@Override
	public void addObjectList(Person person) {
		list.add(person);
	}

	public Person createPerson(String name, char gender) {
		Person person 	=	new Person(name, gender);
		return person;
		
	}

	@Override
	public String toString() {
		return "PersonDAO [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
		
}
