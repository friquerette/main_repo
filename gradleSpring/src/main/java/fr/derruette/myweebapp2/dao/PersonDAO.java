package fr.derruette.myweebapp2.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.derruette.myweebapp2.entity.Person;

public interface PersonDAO {

	public void addPerson(Person p);

	public void updatePerson(Person p);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);

	public SessionFactory getSessionFactory();

}