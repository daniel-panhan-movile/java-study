package com.movile.study.java8.stream.creation;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class FilterMapMain1 {

	/**
	 * Create Stream from a list.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		// Read file into string
		String contents = new String(
				Files.readAllBytes(Paths.get("src/main/resources/alice-in-wondeland.txt")),
				StandardCharsets.UTF_8); 

		List<String> words = Stream.of(contents.split("[\\P{L}]+"))  // Create stream of all words from the string
				.filter(w -> w.length() >= 10)                       // filter words with 10 or more letters 
				.map(String::toUpperCase)                            // transform to upper case
				.distinct()                                          // remove duplicates
				.sorted()                                            // sort the words
				.collect(Collectors.toList());                       // collect as a List

		System.out.println("Words: " + words);
	}

}
