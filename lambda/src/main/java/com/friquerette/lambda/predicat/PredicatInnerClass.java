package com.friquerette.lambda.predicat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.friquerette.lambda.entity.Person;

public class PredicatInnerClass {

	public static void main(String... args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Joe", 48));
		people.add(new Person("Mariam", 30));
		people.add(new Person("Mike", 73));

		Predicate<Person> pred = new Predicate<Person>() {
			@Override
			public boolean test(Person t) {
				return (t.getAge() >= 65);
			}
		};

		for (Person person : people) {
			if (pred.test(person)) {
				System.out.println("c'est un vieux : " + person.getName());
			}
		}
	}
}
