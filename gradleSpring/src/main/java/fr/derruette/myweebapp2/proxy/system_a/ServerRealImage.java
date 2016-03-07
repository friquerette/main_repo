package fr.derruette.myweebapp2.proxy.system_a;

import fr.derruette.myweebapp2.proxy.Image;

//on System A 
public class ServerRealImage implements Image {

	private String filename = null;

	public ServerRealImage(final String filename) {
		this.filename = filename;
		loadImageFromDisk();
	}

	private void loadImageFromDisk() {
		System.out.println("Loading   " + filename);
	}

	@Override
	public String displayImage() {
		String msg = "Displaying " + filename;
		System.out.println(msg);
		return msg;
	}

}