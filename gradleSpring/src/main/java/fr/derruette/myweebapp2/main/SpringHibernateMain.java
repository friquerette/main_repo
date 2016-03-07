package fr.derruette.myweebapp2.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.derruette.myweebapp2.dao.OffreDAO;
import fr.derruette.myweebapp2.dao.PersonDAO;
import fr.derruette.myweebapp2.entity.Person;
import fr.derruette.myweebapp2.service.PersonService;

public class SpringHibernateMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);
		PersonService personService = context.getBean(PersonService.class);

		// Session session = personDAO.getSessionFactory().openSession();
		// Transaction tx = session.beginTransaction();

		Person person = new Person();
		person.setName("test");
		person.setCountry("India");

		// personDAO.addPerson(person);
		// session.persist(person);

		System.out.println("Person::" + person);

		List<Person> list = personService.listPersons();

		for (Person p : list) {
			System.out.println("Person List::" + p);
		}
		// tx.commit();

		// close resources
		context.close();
	}

	@SuppressWarnings("unused")
	private void test() {
		OffreDAO p = new OffreDAO() {

			@Override
			public String creerOffre() {
				// TODO Auto-generated method stub
				return "offre crééer";
			}

		};

		p = new OffrePrive();

	}

	private class OffrePrive implements OffreDAO {

		@Override
		public String creerOffre() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
