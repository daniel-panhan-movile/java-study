package com.movile.study.java8.stream.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Creation4 {

	public static void main(String[] args) {

		// Files.lines(path)
		try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/alice-in-wonderland.txt"))) {;
			lines.limit(12).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--------------");
		
		// Files.list(path)
		try (Stream<Path> paths = Files.list(Paths.get("."))) {
			paths.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
