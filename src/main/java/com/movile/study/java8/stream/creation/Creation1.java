package com.movile.study.java8.stream.creation;

import java.util.Date;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Creation1 {

	public static void main(String[] args) {

		// Stream.of(varargs)
		Stream<String> letters = Stream.of("a", "b", "c", "d", "e");
		System.out.println("of(varargs): " + letters.count());

		// Stream.of(array)
		Stream<String> letters2 = Stream.of("a,b,c,d,e".split(","));
		System.out.println("of(array): " + letters2.count());

		// Stream.of(object)
		Stream<Date> dates = Stream.of(new Date());
		System.out.println("of(object): " + dates.count());

		// Stream.empty
		Stream<String> empty = Stream.empty();
		System.out.println("empty: " + empty.count());
	}

}
