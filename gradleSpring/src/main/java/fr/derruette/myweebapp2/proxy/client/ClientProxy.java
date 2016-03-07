package fr.derruette.myweebapp2.proxy.client;

import fr.derruette.myweebapp2.proxy.Image;
import fr.derruette.myweebapp2.proxy.system_b.ServerProxyImage;

public class ClientProxy {

	public static void main(String[] args) {

		final Image IMAGE1 = new ServerProxyImage("HiRes_10MB_Photo1");

		String msg = IMAGE1.displayImage(); // loading necessary
		System.out.println(msg);
	}

}
