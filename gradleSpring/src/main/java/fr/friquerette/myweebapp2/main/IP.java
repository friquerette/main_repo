package fr.friquerette.myweebapp2.main;

import java.net.URL;
import java.util.Scanner;

public class IP {
	/**
	 * @param site
	 *            l'adresse internet d'un site donnant l'adresse IP
	 * @param prefixe
	 *            le code HTML précédant la valeur de l'adresse IP
	 * @param suffixe
	 *            le code HTML succédant la valeur de l'adresse IP
	 * @return l'adresse IP trouvée ou null sinon
	 */
	public static String findIP(String site, String prefixe, String suffixe) throws Exception {
		Scanner sc = new Scanner(new URL(site).openStream());

		while (sc.hasNextLine()) {
			String line = sc.nextLine();

			int a = line.indexOf(prefixe);
			if (a != -1) {
				int b = line.indexOf(suffixe, a);
				if (b != -1) {
					sc.close();
					return line.substring(a + prefixe.length(), b);
				}
			}
		}

		sc.close();
		return null;
	}

	public static void main(String... args) throws Exception {
		System.out.println(findIP("http://www.myip.dk/", "<b>IP Address:</b> <span class=\"ha4\">", "</span><br />"));
	}
}