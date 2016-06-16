package com.friquerette.lambda.thread;

public class TestRunable {

	public class MyRunnable2 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String... args) {
		// example 1
		MyRunnable r1 = new MyRunnable();
		new Thread(r1).start();

		// example 2
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		};
		new Thread(r2).start();

		// example 3
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello !");
			}
		}).start();

		// example 3
		Runnable r4 = () -> System.out.println("Hello !");
		new Thread(r4).start();

	}
}
