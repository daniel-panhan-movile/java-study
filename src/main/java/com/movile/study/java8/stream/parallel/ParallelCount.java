package com.movile.study.java8.stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author panhan
 */
public class ParallelCount {

	static int N_CPUS = Runtime.getRuntime().availableProcessors();
	static ExecutorService POOL = Executors.newFixedThreadPool(N_CPUS);
	static ForkJoinPool forkJoinPool = new ForkJoinPool(10_000);

	static boolean isPrime(int number) {
		if (number <= 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}

		for (int i = 3; i < number / 2; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		int max = 1_000_000;

		System.out.println("N_CPUS: " + N_CPUS);
		
		long start = System.currentTimeMillis();
		int primeSeq = countSequencial(max);
		System.out.println("Total: " + primeSeq + " - " + (System.currentTimeMillis() - start) + "ms");

		start = System.currentTimeMillis();
		int primeParallel = countParallel(max);
		System.out.println("Total: " + primeParallel + " - " + (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		int primeParallelWithForkJoinPool = countParallelWithForkJoinPool(max);
		System.out.println("Total: " + primeParallelWithForkJoinPool + " - " + (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		int primeExecutors = countExecutors(max, null);
		System.out.println("Total: " + primeExecutors + " - " + (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		int primeExecutors100 = countExecutors(max, 100);
		System.out.println("Total: " + primeExecutors100 + " - " + (System.currentTimeMillis() - start) + "ms");

		forkJoinPool.shutdown();
		POOL.shutdown();
	}

	static int countSequencial(int max) {
		return (int) IntStream.range(0, max).filter((number) -> isPrime(number)).count();
	}

	static int countParallel(int max) {
		return (int) IntStream.range(0, max).parallel().unordered().filter((number) -> isPrime(number)).count();
	}

	static int countParallelWithForkJoinPool(int max) throws InterruptedException, ExecutionException {
		long total = forkJoinPool.submit(() ->
			IntStream.range(0, max).parallel().unordered().filter((number) -> isPrime(number)).count()
		).get();
		return (int) total;
	}
	
	static int countExecutors(int max, Integer partSize) throws InterruptedException, ExecutionException {
		int loops = partSize == null ? N_CPUS : max / partSize + (max % partSize == 0 ? 0 : 1);
		int partition = partSize == null ? max / N_CPUS : partSize;
		int rem = max % loops;

		List<Future<Integer>> futures = new ArrayList<>(loops);

		for (int i = 0; i < loops; i++) {
			int start = i * partition;
			int end = (i + 1) * partition + (i == (loops - 1) ? rem : 0);

			futures.add(POOL.submit(() -> calcPrimesInRange(start, end)));
		}

		int total = 0;
		for (Future<Integer> future : futures) {
			total += future.get();
		}
		return total;
	}

	static int calcPrimesInRange(int start, int end) {
		int primes = 0;
		for (int i = start; i < end; i++) {
			if (isPrime(i)) {
				primes++;
			}
		}
		return primes;
	}
}
