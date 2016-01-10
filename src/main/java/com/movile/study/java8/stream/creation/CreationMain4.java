package com.movile.study.java8.stream.creation;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class CreationMain4 {

	/**
	 * Create stream with File.lines
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();
		long count = 0;
		
		// Java 7 try-with-resources - ensure that the stream will be closed
		try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/alice-in-wondeland.txt"))) {
			count = lines.count();
		};
		
		System.out.println("Total lines: " + count + " [" + (System.currentTimeMillis() - start) + " ms]");
	}

}
