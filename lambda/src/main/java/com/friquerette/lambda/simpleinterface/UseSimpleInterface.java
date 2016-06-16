package com.friquerette.lambda.simpleinterface;

public class UseSimpleInterface {

	public static void main(String... arg) {
		SimpleInterface obj = () -> System.out.println("Say something");
		obj.doSomething();

	}

}
