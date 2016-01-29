package com.movile.study.java8.stream.collecting;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting2 {

	public static void main(String[] args) {

		String[] nameArray = new String[] { "Ana", "Pedro", "Carlos", "João", "Maria", "Clara" };

		// stream.collect(supplier, accumulator, combiner): values
		Stream<String> names = Stream.of(nameArray);
		HashSet<String> hashSet = names.collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println("hashSet: " + hashSet);

		System.out.println("--------------");

		// stream.collect(collector): values
		// Collectors.toList()
		names = Stream.of(nameArray);
		List<String> list = names.collect(Collectors.toList());
		System.out.println("list: " + list);

		System.out.println("--------------");

		// stream.collect(collector): values
		// Collectors.toSet()
		names = Stream.of(nameArray);
		Set<String> set = names.collect(Collectors.toSet());
		System.out.println("set: " + set);

		System.out.println("--------------");

		// stream.collect(collector): values
		// Collectors.toCollection(supplier)
		names = Stream.of(nameArray);
		LinkedList<String> linkedList = names.collect(Collectors.toCollection(LinkedList::new));
		System.out.println("linkedList: " + linkedList);
	}

}
