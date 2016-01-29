package com.movile.study.java8.stream.reduction;

import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Reduction2 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.anyMatch(predicate): boolean
		Stream<String> names = Stream.of(nameArray);
		boolean anyMatch = names.anyMatch((s) -> s.contains("ar"));
		System.out.println(anyMatch);

		System.out.println("--------------");

		// stream.allMatch(predicate): boolean
		names = Stream.of(nameArray);
		boolean allMatch = names.allMatch((s) -> s.contains("a"));
		System.out.println(allMatch);

		System.out.println("--------------");

		// stream.noneMatch(predicate): boolean
		names = Stream.of(nameArray);
		boolean noneMatch = names.noneMatch((s) -> s.length() > 8);
		System.out.println(noneMatch);

	}

}
