package com.movile.study.java8.stream.reduction;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * @author panhan
 */
public class Reduction4 {

	public static void main(String[] args) {

		// stream.sum(): value
		IntStream numbers = IntStream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		int sum = numbers.sum();
		System.out.println(sum);

		System.out.println("--------------");

		// stream.average(): optional
		numbers = IntStream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		OptionalDouble average = numbers.average();
		System.out.println(average.getAsDouble());

		System.out.println("--------------");

		// stream.summaryStatistics(): summaryStatistics
		numbers = IntStream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		IntSummaryStatistics statistics = numbers.summaryStatistics();
		System.out.println(statistics);		

	}

}
