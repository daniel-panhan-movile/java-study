package com.movile.study.java8.stream.creation;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Creation2 {

	public static void main(String[] args) {

		Random rnd = new Random(System.currentTimeMillis());

		// Stream.generate(supplier)
		Stream<Integer> randoms = Stream.generate(rnd::nextInt);
		System.out.println("generate: " + Arrays.toString(randoms.limit(5).toArray(Integer[]::new)));

		// Stream.iterate(seed, unaryOperator)
		Stream<Integer> sequence = Stream.iterate(1, (n) -> n * 2);
		System.out.println("iterate: " + Arrays.toString(sequence.limit(20).toArray(Integer[]::new)));

		// IntStream.range(startInclusive, endExclusive)
		IntStream intStream = IntStream.range(1, 5);
		System.out.println("range: " + intStream.sum());

		// LongStream.rangeClosed(startInclusive, endInclusive)
		LongStream longStream = LongStream.rangeClosed(1L, 5L);
		System.out.println("rangeClosed: " + longStream.sum());
	}

}
