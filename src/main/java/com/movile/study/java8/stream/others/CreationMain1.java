package com.movile.study.java8.stream.others;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author panhan
 */
public class CreationMain1 {

	/**
	 * Create Stream from a list.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String contents = new String(
				Files.readAllBytes(Paths.get("src/main/resources/alice-in-wonderland.txt")),
				StandardCharsets.UTF_8); // Read file into string
		
		long start = System.currentTimeMillis();

		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		long count = words.parallelStream().filter(w -> w.length() > 12).count();

		System.out.println("Total words: " + count + " [" + (System.currentTimeMillis() - start) + " ms]");

	}

}
