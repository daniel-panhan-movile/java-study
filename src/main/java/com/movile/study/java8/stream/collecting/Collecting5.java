package com.movile.study.java8.stream.collecting;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting5 {

	public static void main(String[] args) {

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

	}

}
