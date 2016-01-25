package com.movile.study.java8.stream.transformation;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Transformation3 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.distinct()
		Stream<Integer> numbers = Stream.of(0, 1, 2, 0, 4, 5, 3, 2, 1, 3, 0, 1, 1, 2);
		numbers = numbers.distinct();
		numbers.forEach(System.out::println);

		System.out.println("--------------");

		// stream.sorted()
		numbers = Stream.of(0, 1, 2, 0, 4, 5, 3, 2, 1, 3, 0, 1, 1, 2);
		numbers = numbers.distinct().sorted();
		numbers.forEach(System.out::println);

		System.out.println("--------------");

		// stream.sorted(comparator)
		Stream<String> names = Stream.of(nameArray);
		names = names.sorted(Comparator.comparing(String::length));
		names.forEach(System.out::println);

		System.out.println("--------------");

		// Stream.concat(a, b)
		Stream<Integer> numbers1 = Stream.of(0, 1, 2);
		Stream<Integer> numbers2 = Stream.of(3, 4, 5);
		numbers = Stream.concat(numbers1, numbers2);
		numbers.forEach(System.out::println);

	}

}
