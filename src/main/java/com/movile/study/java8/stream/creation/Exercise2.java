package com.movile.study.java8.stream.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Exercise2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (ShouldClose shouldClose = new ShouldClose()) {
			Integer result = shouldClose.doSomething("abc");
			System.out.println(result);
		}
		System.out.println("After using resource");
		
		
		try (Stream<String> lines = Files
				.lines(Paths.get("src/main/resources/alice-in-wondeland.txt"))
				.onClose(() -> System.out.println("Closing stream..."))) {
			System.out.println(lines.count());
			System.out.println("Inside block");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("After using file");
	}

	public static class ShouldClose implements AutoCloseable {

		public Integer doSomething(String text) {
			return text.length();
		}

		public void close() {
			System.out.println("Closing...");
		};
	}

}
