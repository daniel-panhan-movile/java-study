package com.movile.study.java8.lambda;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
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
		
		System.out.println("[Supplier] " + Stream.generate(supplier3).limit(5).collect(Collectors.toList()));
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
		
		BiConsumer<String, Integer> biConsumer;    // (T, U) -> void
		BiPredicate<String, Integer> biPredicate;  // (T, U) -> boolean

		IntSupplier intSupplier;              // () -> int
		IntConsumer intConsumer;              // (int) -> void 
		IntPredicate intPredicate;            // (int) -> boolean
		IntFunction<String> intFunction;      // (int) -> R
		IntUnaryOperator intUnaryOperator;    // (int) -> int
		IntBinaryOperator intBinaryOperator;  // (int, int) -> (int)
		
		ToIntFunction<String> toIntFunction;           // (T) -> int
		ToIntBiFunction<String, Long> toIntBiFunction; // (T, U) -> int

		LongSupplier longSupplier;              // () -> long
		LongConsumer lintConsumer;              // (long) -> void 
		LongPredicate longPredicate;            // (long) -> boolean
		LongFunction<String> longFunction;      // (long) -> R
		LongUnaryOperator longUnaryOperator;    // (long) -> long
		LongBinaryOperator longBinaryOperator;  // (long, long) -> (long)
		
		ToLongFunction<String> toLongFunction;           // (T) -> long
		ToLongBiFunction<String, Long> toLongBiFunction; // (T, U) -> long
		
		DoubleSupplier doubleSupplier;              // () -> double
		DoubleConsumer doubleConsumer;              // (double) -> void 
		DoublePredicate doublePredicate;            // (double) -> boolean
		DoubleFunction<String> doubleFunction;      // (double) -> R
		DoubleUnaryOperator doubleUnaryOperator;    // (double) -> double
		DoubleBinaryOperator doubleBinaryOperator;  // (double, double) -> (double)
		
		ToDoubleFunction<String> toDoubleFunction;           // (T) -> double
		ToDoubleBiFunction<String, Long> toDoubleBiFunction; // (T, U) -> double

		ObjIntConsumer<String> objIntConsumer;       // (T, int) -> void
		ObjLongConsumer<String> objLongConsumer;     // (T, long) -> void
		ObjDoubleConsumer<String> objDoubleConsumer; // (T, double) -> void

		IntToLongFunction intToLongFunction;        // (int) -> long
		IntToDoubleFunction intToDoubleFunction;    // (int) -> double
		
		LongToIntFunction longToIntFunction;        // (long) -> int
		LongToDoubleFunction longToDoubleFunction;  // (long) -> double
				
		DoubleToIntFunction doubleToIntFunction;     // (double) -> int
		DoubleToLongFunction doubleToLongFunction;   // (double) -> long

		BooleanSupplier booleanSupplier;              // () -> boolean
	}
	
}
