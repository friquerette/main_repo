package fr.friquerette.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * http://blog.sebprunier.com/code/java-7-les-nouveautes-dans-le-langage/
 * 
 * @author ederruette
 *
 */
public class Read7 {

	public static void main(String args[]) {
		String filepath = "src/main/webapp/index.jsp";

		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Erreur : " + e.getMessage());
		}
	}

}
