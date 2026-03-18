package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.IObjectDAO;
import model.Person;

public class PersonController {
	private final IObjectDAO<Person> personDao;
		
	public PersonController(IObjectDAO<Person>  dao) {
		this.personDao = dao;
		
	}
	
	public void addToList(String name, char gender) {
		try {
			Person person = personDao.createObject(new Person(name, gender));
			personDao.addObjectList(person);
			
		} catch(Exception e) {
			System.out.println("Erro ao instanciar pessoa");
		}
		
	}
	
	public HashMap<String, Character> filterListPeople(){
		HashMap<String, Character> filterMap = new HashMap<String, Character>();
		
		List<Person> people = personDao.getAll();
		List<Person> filterPeople = people.stream().filter(e -> e.getGender() == 'F')
				.collect(Collectors.toList());
		
		for(Person p : filterPeople) {
			filterMap.put(p.getName(), p.getGender());
		}
		
		return filterMap;
	     
	}
	
}
