package com.movile.study.java8.stream.collecting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class Collecting4 {

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
		// Collectors.toMap(key, value)
		Stream<Person> persons = personList.stream();
		Map<Long, String> map = persons.collect(Collectors.toMap(Person::getId, Person::getName));
		System.out.println("map: " + map);

		System.out.println("--------------");
		
		// stream.collect(collector): values
		// Collectors.toMap(key, value)
		persons = personList.stream();
		Map<Long, Person> mapPerson = persons.collect(Collectors.toMap(Person::getId, Function.identity()));
		System.out.println("mapPerson: " + mapPerson);

		System.out.println("--------------");

	}

}

class Person {
	private Long id;
	private String name;
	private String address;

	public Person() {
	}

	public Person(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
