package com.movile.study.java8.stream.reduction;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Reduction3 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// reduce(accumulator): optional
		Stream<Integer> numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Optional<Integer> optionalSum = numbers.reduce((x, y) -> x + y);
		System.out.println(optionalSum.get());

		System.out.println("--------------");

		// reduce(identity, accumulator): value
		numbers = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Integer sum = numbers.reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		System.out.println("--------------");

		// reduce(identity,  accumulator, combiner): value
		Stream<String> names = Stream.of(nameArray);
		sum = names.reduce(0,
				(total, name) -> total + name.length(),
				(total1, total2) -> total1 + total2);
		System.out.println("Total letters: " + sum);		

	}

}
