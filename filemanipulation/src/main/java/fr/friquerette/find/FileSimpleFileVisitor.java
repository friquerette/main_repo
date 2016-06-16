package fr.friquerette.find;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSimpleFileVisitor extends SimpleFileVisitor<Path> {

	public static void main(String[] args) throws IOException {
		Path startingDir = Paths.get("C:\\Java\\apache-tomcat-8.0.36\\webapps");
		Files.walkFileTree(startingDir, new FileSimpleFileVisitor());
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

		if (file.toString().endsWith(".java")) {
			System.out.println(file.getFileName());
		}
		return FileVisitResult.CONTINUE;
	}

}
