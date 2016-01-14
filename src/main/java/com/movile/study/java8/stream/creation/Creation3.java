package com.movile.study.java8.stream.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Creation3 {

	public static void main(String[] args) {

		List<String> nameList = Arrays.asList(new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" });

		// collection.stream
		Stream<String> names = nameList.stream();
		names.forEach(System.out::println);

		System.out.println("--------------");

		// Stream.iterate(seed, unaryOperator)
		Stream<String> namesParallel = nameList.parallelStream();
		namesParallel.forEach(System.out::println);

		System.out.println("--------------");

		// Stream.iterate(seed, unaryOperator)
		namesParallel = nameList.parallelStream();
		namesParallel.sequential().forEach(System.out::println);

		System.out.println("--------------");

		// Stream.iterate(seed, unaryOperator)
		namesParallel = nameList.parallelStream();
		namesParallel.unordered().forEach(System.out::println);

	}

}
