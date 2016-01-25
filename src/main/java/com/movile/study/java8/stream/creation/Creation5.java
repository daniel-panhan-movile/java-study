package com.movile.study.java8.stream.creation;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Creation5 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// pattern.splitAsStream(input)
		String value = "1|2|3|4|5";
		Stream<String> numbers = Pattern.compile("\\|").splitAsStream(value);
		numbers.forEach(System.out::println);
		
		System.out.println("--------------");
		
		// Arrays.stream(array)
		Stream<String> names = Arrays.stream(nameArray);
		names.forEach(System.out::println);

		System.out.println("--------------");

		// Arrays.stream(array, startInclusive, endExclusive)
		names = Arrays.stream(nameArray, 1, 4);
		names.forEach(System.out::println);

		System.out.println("--------------");

		// string.codePoints()
		String name = "Daniel Panhan";
	 	IntStream codePoints = name.codePoints();
	 	codePoints.forEach((cp) -> {
	 		System.out.println(cp + " - " + Arrays.toString(Character.toChars(cp)));
	 	});
	}

}
