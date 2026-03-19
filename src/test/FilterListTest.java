package test;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.PersonController;

import org.junit.jupiter.api.Assertions;

import dao.IObjectDAO;
import dao.PersonDAO;
import model.Person;

public class FilterListTest {
	
		@Test
		public void testFilterList() {
			IObjectDAO<Person> dao			  = new PersonDAO();
			PersonController controller = new PersonController(dao);
			
			char gender = 'F';
			
			HashMap<String, Character> list = controller.filterListPeople();
			
			list.forEach((key, value) -> Assertions.assertEquals(gender, value.charValue())); 
			
		}
}
