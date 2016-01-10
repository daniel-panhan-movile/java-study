package com.movile.study.java8.lambda;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author panhan
 */
public class LambaMain1 {

	public static void main(String[] args) {
		
		
		
		// Receive nothing and return void
		Runnable runnable1 = () -> { System.gc(); };  // () -> void
		Runnable runnable2 = () -> System.gc();       // () -> void
		Runnable runnable3 = System::gc;              // () -> void
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(
				() -> System.out.println("[Runnable] " + Thread.currentThread().getName() + " - " + new Date()));
		System.out.println("---------------------------");

		// Receive nothing and return a object
		Supplier<Date> supplier1 = () -> { return new Date(); };     // () -> T 
		Supplier<Date> supplier2 = () -> new Date();                 // () -> T
		Supplier<Date> supplier3 = Date::new;                        // () -> T
		
		System.out.println("[Supplier] " + supplier3.get());
		System.out.println("---------------------------");
		
		// Consume a object and return void
		Consumer<String> consumer1 = (String str) -> { System.out.println(str); }; // (T) -> void
		Consumer<String> consumer2 = (str) -> System.out.println(str);             // (T) -> void
		Consumer<String> consumer3 = System.out::println;                          // (T) -> void
		
		List<String> list1 = Arrays.asList(new String[] {"Ana", "Pedro", "João", "Catarina", "Francisco", "Maria" });
		list1.forEach(consumer3);
		System.out.println("---------------------------");
		
		// Receive a object and return boolean
		Predicate<String> predicate1 = (String str) -> { return str.isEmpty(); };  // (T) -> boolean
		Predicate<String> predicate2 = (str) -> str.isEmpty();                     // (T) -> boolean
		Predicate<String> predicate3 = String::isEmpty;                            // (T) -> boolean
		
		Stream<String> stream1 = Stream.of(new String[] {"Ana", "", "João", "Catarina"});
		stream1.filter((str) -> !str.isEmpty()).forEach(consumer2);
		System.out.println("---------------------------");
		
		// Receive a object and return another object
		Function<String, Integer> function1 = (String str) -> { return str.length(); };  // (T) -> R
		Function<String, Integer> function2 = (str) -> str.length();                     // (T) -> R
		Function<String, Integer> function3 = String::length;                            // (T) -> R
		
		Stream<String> stream2 = Stream.of(new String[] {"Ana", "Pedro", "João", "Catarina", "Francisco", "Maria" });
		stream2.map(function3).forEach(System.out::println);
		System.out.println("---------------------------");

		// Receive a object and return a object of the same type
		UnaryOperator<String> unaryOperator1 = (String str) -> { return str.toUpperCase(); };    // (T) -> T
		UnaryOperator<String> unaryOperator2 = (str) -> str.toUpperCase();                       // (T) -> T
		UnaryOperator<String> unaryOperator3 = String::toUpperCase;                              // (T) -> T
		
		// Receive two objects and return a object of the same type
		BinaryOperator<String> binaryOperator1 = (String str1, String str2) -> { return str1.concat(str2); };  // (T, T) -> T
		BinaryOperator<String> binaryOperator2 = (str1, str2) -> str1.concat(str2);                            // (T, T) -> T
		BinaryOperator<String> binaryOperator3 = String::concat;                                               // (T, T) -> T
		Stream<String> stream3 = Stream.of(new String[] {"Ana", "Pedro", "João", "Catarina", "Francisco", "Maria" });
		System.out.println(stream3.reduce(binaryOperator3).orElse(""));
		
		executorService.shutdown();	
	}
	
}
