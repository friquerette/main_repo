package fr.friquerette.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Read8 {

	public static void main(String args[]) {
		String filepath = "src/main/webapp/index.jsp";
		List<String> list = new ArrayList<>();
		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(filepath))) {

			list = stream.collect(Collectors.toList());
			list.forEach(System.out::println);
			// list.stream()
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
