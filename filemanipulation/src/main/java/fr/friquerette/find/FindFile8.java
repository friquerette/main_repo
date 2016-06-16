package fr.friquerette.find;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;

/**
 * @url "http://www.java2s.com/Tutorials/Java/Java_Lambda/0190__Java_Lambda_body_statements.htm"
 * 
 *      Not finish, see with a body statement
 * 
 * @author ederruette
 *
 */
public class FindFile8 {

	public static void main(String... args) {
		String fileToFind = "401.jsp";
		String directory = "C:\\Java\\apache-tomcat-8.0.36";
		BiFunction<Path, String, String> bi = (path, file) -> {

			if (path.toFile().isDirectory()) {
				System.out.println("ok");
				findFile(path, file);
			} else {
				if (fileToFind.equals(path.getFileName().toString())) {
					System.out.println("yes !!!");
					return path.toFile().getPath();
				}
			}
			return null;
		};
		bi.apply(Paths.get(directory), fileToFind);
	}

	public static String findFile(Path directory, String fileToFind) {
		String pathFind = null;

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
			for (Path path : directoryStream) {
				System.out.println(path.getFileName());
				String fileFound = findFile(path, fileToFind);
				System.out.println(path.getFileName());
				if (fileFound != null) {
					pathFind = fileFound;
				}
				break;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return pathFind;
	}

	public static String findFile2(String directory, String fileToFind) {
		return null;
	}

}
