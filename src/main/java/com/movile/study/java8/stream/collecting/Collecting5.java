package com.movile.study.java8.stream.collecting;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting5 {

	public static void main(String[] args) {

		List<Person> personList = new ArrayList<>();
		Person person1 = new Person(1L, "Ana", "Rua A, 1");
		personList.add(person1);
		Person person2 = new Person(2L, "Pedro", "Rua B, 2");
		personList.add(person2);
		Person person3 = new Person(3L, "Carlos", "Rua C, 3");
		personList.add(person3);
		Person person4 = new Person(4L, "João", "Rua D, 4");
		personList.add(person4);

		// stream.collect(collector): values
		// Collectors.groupingBy(classifier)
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, List<Locale>> languageToLocales = locales.collect(
				Collectors.groupingBy(Locale::getDisplayLanguage));
		System.out.println(languageToLocales);
		
		System.out.println("--------------");
		
		// stream.collect(collector): values
		// Collectors.groupingBy(classifier, downstream)
		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Long> languageToLocalesCounting = locales.collect(
				Collectors.groupingBy(
						Locale::getDisplayLanguage,
						Collectors.counting()));
		System.out.println(languageToLocalesCounting);

		System.out.println("--------------");
		
		// stream.collect(collector): values
		// Collectors.partitioningBy(predicate)
		locales = Stream.of(Locale.getAvailableLocales());
		Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
				Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
		List<Locale> englishLocales = englishAndOtherLocales.get(true);
		System.out.println(englishLocales);
		
		System.out.println("--------------");
		
		// stream.collect(collector): values
		// Collectors.groupingBy(classifier, downstream)
		// Collectors.mapping(function, downstream)
		locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> languageToLocalesMapping = locales.collect(
				Collectors.groupingBy(
						Locale::getDisplayLanguage,
						Collectors.mapping(Locale::getDisplayCountry, Collectors.toSet())));
		System.out.println(languageToLocalesMapping);

		System.out.println("--------------");
	}

}
