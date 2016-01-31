package com.movile.study.java8.stream.collecting;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

/**
 * @author panhan
 */
public class Collecting6 {

	static List<City> citiesList = new ArrayList<>();
	
	public static void main(String[] args) {

		// stream.collect(collector): values
		// Collectors.groupingBy(classifier, downstream)
		// Collectors.counting()
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Long> languageToLocalesCounting = locales.collect(
				Collectors.groupingBy(
						Locale::getDisplayLanguage,
						Collectors.counting()));
		System.out.println(languageToLocalesCounting);

		System.out.println("--------------");
		
		// stream.collect(collector): values
		// Collectors.groupingBy(classifier, downstream)
		// Collectors.maxBy(comparator)
		Stream<City> cities = citiesList.stream();
		Map<String, Optional<City>> citiesMaxByState = cities.collect(
				Collectors.groupingBy(
						City::getState,
						TreeMap::new,
						Collectors.maxBy(Comparator.comparing(City::getPopulation))));
		citiesMaxByState.forEach((s, c) -> System.out.println(s + ": " + c.get().getName()));

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
		
		// stream.collect(collector): values
		// Collectors.groupingBy(classifier, downstream)
		// Collectors.maxBy(comparator)
		cities = citiesList.stream();
		Map<String, LongSummaryStatistics> citiesSummaryByState = cities.collect(
				Collectors.groupingBy(
						City::getState,
						TreeMap::new,
						Collectors.summarizingLong(City::getPopulation)));
		citiesSummaryByState.forEach((st, sm) -> System.out.println(st + ": " + sm));

		System.out.println("--------------");
	}
	
	static {
		 try {
			CSVParser csv = CSVParser.parse(new File("src/main/resources/cities.csv"), Charset.forName("UTF-8"), CSVFormat.DEFAULT);
			csv.forEach((r) -> {
				citiesList.add(new City(r.get(0), r.get(1), new Long(r.get(2)))); 
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class City {
	private String name;
	private String state;
	private Long population;

	public City(String name, String state, Long population) {
		this.name = name;
		this.state = state;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", state=" + state + ", population=" + population + "]";
	}

}
