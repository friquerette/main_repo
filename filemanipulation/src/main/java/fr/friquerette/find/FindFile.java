package fr.friquerette.find;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindFile {

	public static void main(String... args) {
		String directory = "C:\\temp\\backup\\8.0.1";
		directory = "C:\\Java\\apache-tomcat-8.0.36";

		String fileToFind = "activities.sql";
		fileToFind = "RELEASE-NOTES";
		fileToFind = "401.jsp";
		System.out.println("BINGO=" + findFile(directory, fileToFind));

	}

	public static String findFile(String directory, String fileToFind) {
		String pathFind = null;
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
			for (Path path : directoryStream) {
				if (path.toFile().isDirectory()) {
					String fileFound = findFile(path.toFile().getPath(), fileToFind);
					if (fileFound != null) {
						return fileFound;
					}
				} else {
					if (fileToFind.equals(path.getFileName().toString())) {
						System.out.println("yes !!!");
						return path.toFile().getPath();
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return pathFind;
	}
}
