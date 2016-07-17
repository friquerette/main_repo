package com.friquerette.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest {
	public static void main(String... arg) throws Exception {
		deque();

	}

	public static void deque() {
		Deque<String> dequeA = new LinkedList<>();
		dequeA.add("Harrison");
		dequeA.add("McCartney");
		dequeA.addLast("Starr");
		dequeA.addFirst("Lennon");
		System.out.println(dequeA);
		// Copy in other deque
		Deque<String> dequeB = new LinkedList<>();
		dequeB.addAll(dequeA);
		Deque<String> dequeC = new LinkedList<>();
		dequeC.addAll(dequeA);
		while (!dequeA.isEmpty()) {
			System.out.println("Removing from first " + dequeA.removeFirst());
		}
		System.out.println("---");
		while (!dequeB.isEmpty()) {
			System.out.println("Removing from last " + dequeB.removeLast());
		}
		System.out.println("---");
		System.out.println(dequeC);
		System.out.println("Read Last " + dequeC.getLast());
		System.out.println("Read First " + dequeC.getFirst());
		System.out.println("Read (peek) Last " + dequeC.peekLast());
		System.out.println("Read (peek) First " + dequeC.peekFirst());
		System.out.println("Remove (poll) Last " + dequeC.pollLast());
		System.out.println("Remove (poll) First " + dequeC.pollFirst());
		System.out.println(dequeC);
	}

	public static void queue() {
		Queue<String> loginSequence = new LinkedList<>();
		loginSequence.add("Harrison");
		loginSequence.add("McCartney");
		loginSequence.add("Starr");
		loginSequence.add("Lennon");
		System.out.println("The login sequence is: " + loginSequence);
		LinkedList<String> copySequence = new LinkedList<>();
		copySequence.addAll(loginSequence);
		while (!loginSequence.isEmpty()) {
			System.out.println("Removing " + loginSequence.remove());
		}
		System.out.println("The empty login sequence is: " + loginSequence);
		loginSequence.peek();
		loginSequence.poll();
		try {
			loginSequence.element();
		} catch (NoSuchElementException e) {
			System.out.println("error : no element");
		}
		System.out.println("The copySequence sequence is: " + copySequence);
		System.out.println("getLast " + copySequence.getLast());
		System.out.println("The copySequence sequence is: " + copySequence);
		// Retrieves and removes the head (first element) of this list.
		// throws NoSuchElementException if this list is empty
		System.out.println("remove " + copySequence.remove());
		System.out.println("The copySequence sequence is: " + copySequence);
		// read the element but leave it in the queue
		System.out.println("peek " + copySequence.peek());
		System.out.println("The copySequence sequence is: " + copySequence);
		// idem remove but no exception return null
		System.out.println("poll " + copySequence.poll());
		System.out.println("The copySequence sequence is: " + copySequence);
	}

	public static void treemap() {
		Comparator<Integer> comparator = (Integer u1, Integer u2) -> u1.compareTo(u2);
		NavigableMap<Integer, String> examScores = new TreeMap<>(comparator);
		examScores.put(90, "Sophia");
		examScores.put(20, "Isabella");
		examScores.put(10, "Emma");
		examScores.put(50, "Olivea");
		System.out.println("The data in the map is: " + examScores);
		System.out.println("The data descending order is: " + examScores.descendingMap());
		System.out.println("Details of those who passed the exam: " + examScores.tailMap(40));
		System.out.println("The lowest mark is: " + examScores.firstEntry());
	}

	public static void hashset2() {
		Map<String, String> misspeltWords = new HashMap<>();
		misspeltWords.put("calender", "calendar");
		misspeltWords.put("tomatos", "tomatoes");
		misspeltWords.put("existance", "existence");
		misspeltWords.put("aquaintance", "acquaintance");
		String sentence = "Buy a calender for the year 2013";
		System.out.println("The given sentence is: " + sentence);
		for (String word : sentence.split("\\W+")) {
			if (misspeltWords.containsKey(word)) {
				System.out.println("The correct spelling for " + word + " is: " + misspeltWords.get(word));
			}
		}
		misspeltWords.entrySet();
	}

	public static void treeset() {
		Comparator<Character> comparatorReverse = (Character u1, Character u2) -> -u1.compareTo(u2);
		Comparator<Character> comparator = new Comparator<Character>() {
			@Override
			public int compare(Character u1, Character u2) {
				return u1.compareTo(u2);
			}

		};
		String pangram = "the quick brown fox jumps over the lazy dog";
		Set<Character> aToZee = new TreeSet<>(comparatorReverse);
		for (char gram : pangram.toCharArray())
			aToZee.add(gram);
		System.out.println("The pangram is: " + pangram);
		System.out.print("Sorted pangram characters are: " + aToZee);
	}

	public static void hashset() {
		String tongueTwister = "I feel, a feel, a funny feel, a funny feel I feel, if you feel the feel I feel, I feel the feel you feel";
		Set<String> words = new HashSet<>();
		// split the sentence into words and try putting them in the set
		for (String word : tongueTwister.split("\\W+"))
			words.add(word);
		System.out.println("The tongue twister is: " + tongueTwister);
		System.out.print("The words used were: ");
		System.out.println(words);

	}

	public static void palindrome() {
		String palStr = "abcba";
		List<Character> palindrome = new LinkedList<Character>();
		for (char ch : palStr.toCharArray())
			palindrome.add(ch);
		System.out.println("Input string is: " + palStr);
		ListIterator<Character> iterator = palindrome.listIterator();
		Iterator<Character> iterator2 = palindrome.iterator();
		ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());
		boolean result = true;
		while (revIterator.hasPrevious() && iterator.hasNext()) {
			if (iterator.next() != revIterator.previous()) {
				result = false;
				break;
			}
		}
		if (result)
			System.out.print("Input string is a palindrome");
		else
			System.out.print("Input string is not a palindrome");

	}

	public static void arrayList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer(15));
		list.add(new Integer(25));
		LinkedList<Integer> listLinked = new LinkedList<>();
		listLinked.addAll(list);
		System.out.println(listLinked);
		listLinked.add(11);
		System.out.println(listLinked);
		listLinked.addLast(31);
		System.out.println(listLinked);
		listLinked.addFirst(21);
		System.out.println(listLinked);

		Iterator<Integer> iterator = list.iterator();
		ListIterator<Integer> listIterator = list.listIterator(list.size());
		for (; listIterator.hasPrevious();) {
			System.out.println(listIterator.previousIndex() + " " + listIterator.previous());
		}

	}

	public void arrayList2() {

		List<Integer> intList = Collections.nCopies(2, new Integer(10));
		// intList.set(0, 25);
		// intList.add(10);
		for (Integer integer : intList) {
			// System.out.println(integer);
		}

		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer(15));
		list.add(new Integer(25));
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("- set one item");
		list.set(0, 25);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("- Collections fill");
		Collections.fill(list, new Integer(15));
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("- set one item");
		list.set(0, 25);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("- set one item");
		Collections.copy(list, intList);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		List<Integer> listInteger = new ArrayList<Integer>();
		List listWithoutType = new ArrayList();

	}
}
