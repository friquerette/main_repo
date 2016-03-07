package fr.friquerette.myweebapp2.proxy.system_b;

import fr.friquerette.myweebapp2.proxy.Image;
import fr.friquerette.myweebapp2.proxy.system_a.ServerRealImage;

//on System B 
public class ServerProxyImage implements Image {

	private ServerRealImage image = null;
	private String filename = null;

	public ServerProxyImage(final String filename) {
		this.filename = filename;
	}

	@Override
	public String displayImage() {
		if (image == null) {
			image = new ServerRealImage(filename);
		}
		String msg = image.displayImage();
		System.out.println("Proxy doing :" + msg);
		return msg;
	}

}