package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HashMapKey {
	public static void main(String a[]) {

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "ONE");
		map.put(2, "TWO");
		map.put(3, "THREE");
		map.put(4, "FOUR");
		map.put(5, "FIVE");
		map.put(6, "SIX");
		map.put(7, "SEVEN");
		map.put(8, "EIGHT");
		map.put(9, "NINE");
			//Getting the Keys From the Map
		  List<Integer> collect = map.entrySet().stream().map(Map.Entry::getKey)
				  .collect(Collectors.toList());;
			//Printing  the keys
		  collect.forEach(System.out::println);
		  //Calling the Prime Function
		  List<Integer> primeList = collect.stream().filter(HashMapKey::isPrime)
				  .collect(Collectors.toList());
		 
		  primeList.forEach(System.out::println); 
	}
	
	 public static boolean isPrimeTraditional(int number) {
	        for (int i = 2; i <= number / 2; i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 public static boolean isPrime(int number) {	 
		 return !IntStream.rangeClosed(2, number/2).anyMatch(i ->number % i == 0);
	 }
	 
}
