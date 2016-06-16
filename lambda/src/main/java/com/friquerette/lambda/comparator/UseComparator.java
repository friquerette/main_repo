package com.friquerette.lambda.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UseComparator {

	/**
	 * Todo search on iterator : foreach & spliterator Consummer : method
	 * accept(T t)
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		List<String> strings = new ArrayList<String>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");

		// example 1
		// Simple case-sensitive sort operation
		Collections.sort(strings);
		System.out.println("Simple sort");
		print("example 1", strings);

		// example 2
		// Case-insensitive sort with an anonymous class
		Collections.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareToIgnoreCase(str2);
			}
		});
		System.out.println("Sort with comparator");
		print2("example 2", strings);

		// example 3
		Comparator<String> comp = (str1, str2) -> {
			return str1.compareToIgnoreCase(str2);
		};
		Collections.sort(strings, comp);
		print3("example 3", strings);

	}

	private static void print(String label, List<String> strings) {
		System.out.println("\n\n" + label);
		for (String str : strings) {
			System.out.println(str);
		}
	}

	private static void print2(String label, List<String> strings) {
		System.out.println("\n\n" + label);
		Iterator<String> i = strings.iterator();
		while (i.hasNext()) {
			String str = i.next();
			System.out.println(str);
		}
	}

	private static void print3(String label, List<String> strings) {
		System.out.println("\n\n" + label);
		strings.forEach(str -> System.out.println(str));
	}
}
