package com.movile.study.java8.stream.collecting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting1 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };
		Random rnd = new Random(System.currentTimeMillis());

		// stream.toArray(): object[]
		Stream<Integer> randoms = Stream.generate(rnd::nextInt);
		Object[] objectArr = randoms.limit(10).toArray();
		System.out.println(Arrays.toString(objectArr));

		System.out.println("--------------");

		// stream.toArray(generator): values[]
		randoms = Stream.generate(rnd::nextInt);
		Integer[] integerArr = randoms.limit(10).toArray(Integer[]::new);
		System.out.println(Arrays.toString(integerArr));

		System.out.println("--------------");
		
		// stream.forEach(consumer): void
		Stream<String> names = Stream.of(nameArray);
		names.parallel().forEach(System.out::println);

		System.out.println("--------------");
		
		// stream.forEach(consumer): void
		names = Stream.of(nameArray);
		names.parallel().forEachOrdered(System.out::println);
	}

}
