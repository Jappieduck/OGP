package Les_1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Les1 {
	/**
	 * @inspects nothing |
	 */
	static boolean isSameObject(int[] a1, int[] a2) {
		return a1 == a2;
	}
	
	/**
	 * Finds the index where the given value belongs in the given sorted array.
	 * @pre | numbers != null
	 * @pre | IntStream.range(1,numbers.length).allMatch(i -> numbers[i-1] <= numbers[i])
	 * @inspects | numbers
	 * @post | 0 <= result && result <= numbers.length
	 * @post | IntStream.range(0,result).allMatch(i -> numbers[i] < value)
	 * @post | IntStream.range(result, numbers.length).allMatch(i -> value <= numbers[i])
	 */
	static int binarySearch(int[] numbers, int value) {
		int lo = 0;
		int hi = numbers.length;
		while (lo < hi) {
			int middle = lo + (hi - lo)/2;
			if (numbers[middle] < value)
				lo = middle + 1;
			else
				hi = middle;
		}
		return lo;
	}
	
	/**
	 * Inserts the given value into the sequence of numbers stored in the given sorted array at indices 0 
	 * (inclusive) through n (exclusive)
	 * @pre | numbers != null
	 * @pre | 0 <= n && n < numbers.length
	 * @pre | IntStream.range(1,n).allMatch(i -> numbers[i-1] <= numbers[i])
	 * @post | IntStream.range(1,n+1).allMatch(i -> numbers[i-1] <= numbers[i])
	 * @post | IntStream.range(0,n+1).allMatch( i -> 
	 * 		 |		IntStream.range(0,n+1).filter(j -> numbers[j] == numbers[i]).count() ==
	 * 		 | 		(numbers[i] == value ? 1:0) + IntStream.range(0,n).filter(j -> 
	 * 		 | 		old(numbers.clone())[j] == numbers[i]).count())
	 */
	static void insert(int[] numbers, int n, int value) {
		int i = 0;
		while(i < n && numbers[i] < value)
			i++;
		for(int j = n; i < j; j--)
			numbers[j] = numbers[j-1];
		numbers[i] = value;
	}
	/** 
	 * Sorts a given array of numbers
	 * @throws IllegalArgumentException if the given array reference is null
	 * 		 | numbers == null
	 * @mutates | numbers
	 * @post The elements in the array are in ascending order
	 * 		 | IntStream.range(1,numbers.length).allMatch(i -> numbers[i-1] <= numbers[i])
	 * @post The elements in the array are the same as before.
	 * 		 | Arrays.stream(numbers).allMatch(e ->
	 * 		 | IntStream.range(0,numbers.length).filter(i -> numbers[i] == e).count() ==
	 * 		 | IntStream.range(0,numbers.length).filter(i -> old(numbers.clone())[i] == e).count()
	 * 		 | )
	 */
	static void insertionSort(int[] numbers) {
		if (numbers == null)
			throw new IllegalArgumentException("`numbers` is null");
		for (int i = 1; i < numbers.length; i++) {
			insert(numbers, i, numbers[i]);
		}
	}
}

