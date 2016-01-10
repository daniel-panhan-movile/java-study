package com.movile.study.java8.stream.creation;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class CreationMain2 {

	/**
	 * Create Stream from a array.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String contents = new String(
				Files.readAllBytes(Paths.get("src/main/resources/alice-in-wondeland.txt")),
				StandardCharsets.UTF_8); // Read file into string
		
		long start = System.currentTimeMillis();

		Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
		long count = words.parallel().filter(w -> w.length() > 12).count();

		System.out.println("Total words: " + count + " [" + (System.currentTimeMillis() - start) + " ms]");
	}

}
