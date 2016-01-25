package com.movile.study.java8.stream.reduction;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Reduction1 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.count(): long
		Stream<Integer> numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		long total = numbers.count();
		System.out.println("stream.count(): " + total);

		System.out.println("--------------");

		// stream.min(comparator): optional
		Stream<String> names = Stream.of(nameArray);
		Optional<String> min = names.min(Comparator.comparing(String::length));
		System.out.println(min.get());

		System.out.println("--------------");

		// stream.max(comparator): optional
		names = Stream.of(nameArray);
		Optional<String> max = names.max(Comparator.comparing(String::length));
		System.out.println(max.get());

		System.out.println("--------------");

		// stream.findFirst(): optional
		names = Stream.of(nameArray);
		Optional<String> first = names.filter((s) -> s.charAt(0) == 'C').findFirst();
		System.out.println(first.get());

		System.out.println("--------------");

		// stream.findAny(): optional
		names = Stream.of(nameArray);
		Optional<String> any = names.parallel().filter((s) -> s.charAt(0) == 'C').findAny();
		System.out.println(any.get());

	}

}
