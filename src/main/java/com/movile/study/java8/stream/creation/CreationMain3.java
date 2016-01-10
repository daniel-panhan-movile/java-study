package com.movile.study.java8.stream.creation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class CreationMain3 {

	/**
	 * Create stream with generate and iterate
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		
		long start = System.currentTimeMillis();

		Stream<Double> randoms = Stream.generate(Math::random);
		randoms = randoms.limit(10);
		List<Double> rnds = randoms.collect(Collectors.toList());

		System.out.println("Randoms: " +  rnds + " [" + (System.currentTimeMillis() - start) + " ms]");

		start = System.currentTimeMillis();

		Stream<Integer> range = Stream.iterate(0, s -> s + 2);
		range = range.limit(10);
		List<Integer> rg = range.collect(Collectors.toList());

		System.out.println("Range 2 by 2: " +  rg + " [" + (System.currentTimeMillis() - start) + " ms]");
	}

}
