package controller;

import java.util.List;
import java.util.stream.Collectors;

import dao.IObjectDAO;
import model.Person;

public class PersonController {
	private final IObjectDAO<Person> personDao;
		
	public PersonController() {
		this.personDao = null;
		
	}
	
	public void addToList(String name, char gender) {
		try {
			Person person = personDao.createObject(new Person(name, gender));
			personDao.addObjectList(person);
			
		} catch(Exception e) {
			System.out.println("Erro ao instanciar pessoa");
		}
		
	}
	
	public List<Person> filterListPeople(){
		List<Person> people = personDao.getAll();
		return people.stream().filter(e -> e.getGender() == 'F')
				.collect(Collectors.toList());
	}
	
}
