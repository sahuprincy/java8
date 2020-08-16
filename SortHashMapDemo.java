package java8.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer, Integer> hmap = new HashMap<>();

		hmap.put(8, 7);
		hmap.put(6, 9);
		hmap.put(9, 8);

		List<Map.Entry<Integer, Integer>> sortByKeys = hmap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());
		System.out.println("hmap :: " + hmap);
		System.out.println("sortByKeys :: " + sortByKeys);

		List<Map.Entry<Integer, Integer>> sortByValues = hmap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());
		System.out.println("sortByValues :: " + sortByValues);

	}
}
