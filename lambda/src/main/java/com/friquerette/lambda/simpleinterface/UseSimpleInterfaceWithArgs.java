package com.friquerette.lambda.simpleinterface;

public class UseSimpleInterfaceWithArgs {

	public static void main(String[] args) {
		SimpleInterfaceWithArgs obj = (v1, v2) -> {
			int result = v1 * v2;
			System.out.println("the result is " + result);
		};
		obj.calculate(2, 3);
	}

}
