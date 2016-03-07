package fr.derruette.myweebapp2.main;

public class D implements Comparable<Object> {

	@SuppressWarnings("unused")
	public D() {
		System.out.println("D");
		Object a;
		String b;
		Integer i;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}