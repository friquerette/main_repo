package fr.friquerette.myweebapp2.service;

import java.util.List;

import fr.friquerette.myweebapp2.entity.Person;

public interface PersonService {

	public void addPerson(Person p);

	public void updatePerson(Person p);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);

}
