package com.movile.study.java8.stream.collecting;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting3 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.collect(collector): values
		// Collectors.joining(delimiter)
		Stream<String> names = Stream.of(nameArray);
		String joining = names.collect(Collectors.joining("; "));
		System.out.println("joining: " + joining);

		System.out.println("--------------");

		// stream.collect(collector): values
		// Collectors.summarizingInt(function)
		names = Stream.of(nameArray);
		IntSummaryStatistics intSummaryStatistics = names.collect(Collectors.summarizingInt(String::length));
		System.out.println(intSummaryStatistics);

	}

}
