package com.movile.study.java8.stream.transformation;

import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Transformation2 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.limit(maxSize)
		Stream<Integer> numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers = numbers.limit(3);
		numbers.forEach(System.out::println);

		System.out.println("--------------");

		// stream.skip(n)
		numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers = numbers.skip(3);
		numbers.forEach(System.out::println);

		System.out.println("--------------");

		// stream.peek(consumer)
		Stream<String> names = Stream.of(nameArray);
		names
			.filter((s) -> s.contains("a"))
			.peek((s) -> System.out.println("--> " + s))
			.filter((s) -> s.charAt(0) == 'C')
			.forEach(System.out::println);
	}

}
