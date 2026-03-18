package dao;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Person;

public class PersonDAO implements IObjectDAO<Person> {
	
	private final List<Person> list = new ArrayList<Person>();

	@Override
	public void addObjectList(Person person) {
		list.add(person);
	}

	public Person createObject(Person p) throws Exception {
		Class<Person> pc 		= Person.class;
		Constructor<Person> con = pc.getConstructor(String.class, char.class);
		Person person = (Person) con.newInstance(p.getName(), p.getGender());
		
		return person;
		
	}
	
	@Override
	public List<Person> getAll(){
		return Collections.unmodifiableList(list);
	}


		
}
