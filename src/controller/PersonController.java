package controller;

import java.util.List;
import java.util.stream.Collectors;


import dao.PersonDAO;
import model.Person;

public class PersonController {
	public PersonDAO personDao = new PersonDAO();
		
	public PersonController() {
		
	}
	
	public void addToList(String name, char gender) {
		Person person = personDao.createPerson(name, gender);
		personDao.addObjectList(person);
	}
	
	public List<Person> filterListPeople(){
		List<Person> people = PersonDAO.getList();
		return people.stream().filter(e -> e.getGender() == 'F')
				.collect(Collectors.toList());
	}
	
}
