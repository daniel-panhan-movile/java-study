package com.movile.study.java8.stream.transformation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Transformation1 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.filter(predicate)
		Stream<Integer> numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers = numbers.filter((n) -> n >= 2 && n < 7);
		numbers.forEach(System.out::println);

		System.out.println("--------------");

		// map(function): Stream
		Stream<String> names = Stream.of(nameArray);
		names = names.map(String::toUpperCase);
		names.forEach(System.out::println);

		System.out.println("--------------");

		// map(function): Stream
		names = Stream.of(nameArray);
		Stream<Character> firstLetter = names.map((s) -> s.charAt(0));
		firstLetter.forEach(System.out::println);

		System.out.println("--------------");

		// mapToInt(intFunction): IntStream
		names = Stream.of(nameArray);
		IntStream namesLength = names.mapToInt(String::length);
		namesLength.forEach(System.out::println);

		System.out.println("--------------");
		
		// flatMap(function): Stream
		names = Stream.of(nameArray); 
		
		// Stream<Stream<Character>> namesChars = names.map((s) -> characterStream(s));
		Stream<Character> namesChars = names.flatMap((s) -> characterStream(s));
		namesChars.forEach(System.out::println);
		
	}

	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray())
			result.add(c);
		return result.stream();
	}
}
