package com.movile.study.java8.stream.reduction;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Optional1 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		/// ----------- Optional with 'Carlos' --------------
		Stream<String> names = Stream.of(nameArray);
		Optional<String> first = names.filter((s) -> s.charAt(0) == 'C').findFirst();

		// optional.isPresent(): boolean
		if (first.isPresent()) {
			// optional.get(): value
			System.out.println(first.get());
		} else {
			System.out.println("No name starting with 'C'.");
		}

		System.out.println("--------------");

		// optional.ifPresent(consumer): void
		first.ifPresent((s) -> System.out.println("Found " + s));

		System.out.println("--------------");

		/// ----------------------------------------

		/// ---------- Optional empty --------------
		names = Stream.of(nameArray);
		first = names.filter((s) -> s.charAt(0) == 'T').findFirst();

		// optional.orElse(default): value
		System.out.println(first.orElse("Not found name starting with 'T'."));

		System.out.println("--------------");

		// optimal.orElseGet(supplier): value
		System.out.println(first.orElseGet(() -> new Date().toString()));

		System.out.println("--------------");

		// optimal.orElseThrow(exception): value
		try {
			System.out.println(first.orElseThrow(() -> new Exception("Not found name starting with 'T'.")));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
