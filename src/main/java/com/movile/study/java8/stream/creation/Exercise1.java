package com.movile.study.java8.stream.creation;

import java.io.File;
import java.util.Arrays;
import java.util.function.Function;

/**
 * @author panhan
 */
public class Exercise1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(".");
		File[] files = file.listFiles(File::isDirectory);
		System.out.println(Arrays.toString(files));

		String[] names = file.list((dir, name) -> {
			return dir.getName().equals(".") && name.equals("src");
		});
		System.out.println(Arrays.toString(names));

		String result = doSomething("teste", (s) -> s.toUpperCase());
		System.out.println(result);

		result = doSomething("TESTE", String::toLowerCase);
		System.out.println(result);

	}

	public static String doSomething(String s, Function<String, String> f) {
		System.out.println("before");
		String result = f.apply(s);
		System.out.println("after");
		return result;
	}

}
