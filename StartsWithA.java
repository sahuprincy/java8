package java8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import practise.model.Employee;



public class StartsWithA {

	public static void main(String[] args) {
		List<String> l = Arrays.asList("Alex", "ABD", "Scott", "Morgan");
		// starts with
		List<String> filteredResponse = l.stream().filter(p -> p.startsWith("A")).collect(Collectors.toList());
		filteredResponse.forEach(System.out::println);
		System.out.println("=================");
		List<String> elements = l.stream().limit(2).map(String::toUpperCase).collect(Collectors.toList());
		elements.forEach(System.out::println);

		System.out.println("=================");
		List<String> upperCase = l.stream().map(String::toUpperCase).collect(Collectors.toList());
		upperCase.forEach(System.out::println);

		System.out.println("=================");

		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(10);
		stack.push(90);
		stack.push(40);
		stack.push(100);
		stack.push(80);

		List<Integer> stackList = stack.stream().collect(Collectors.toList());
		stackList.forEach(System.out::println);

		System.out.println("=================");
		String[] myArray = { "this", "is", "a", "sentence" };
		String result = Arrays.stream(myArray).reduce("", (a, b) -> a + b);
		System.out.println(result);

		System.out.println("=================");
		List<Item> list = IntStream.rangeClosed(1, 4).mapToObj(Item::new).collect(Collectors.toList()); // [Item [i=1],
																										// Item [i=2],
																										// Item [i=3],
																										// Item [i=4]]

		Map<String, Item> map = list.stream().collect(Collectors.toMap(Item::getKey, item -> item));

		
		map.forEach((k, v) -> System.out.println(k + " => " + v));
		
		System.out.println("=================");

		
		List<Employee> empList= new ArrayList<>();
		Employee e1= new Employee(1, "Princy",29);
		Employee e2= new Employee(1, "Alex",45);
		Employee e3= new Employee(1, "Adam",32);
		Employee e4= new Employee(1, "Alex",28);
		
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		List<Employee> eList = empList.stream().sorted(Comparator.comparing(Employee::getName).
				thenComparing(Employee::getAge)).collect(Collectors.toList());
		eList.forEach(System.out::println);
		
		
		printCountOfDuplicateCharMapCompute("efafafadgsfhsfa5452");
		
		System.out.println("=================");
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		    numbers.stream()
		           .filter(value -> value % 2 == 0)
		           .forEach(System.out::println);
		  
	
	}
	
	private static void printCountOfDuplicateCharMapCompute(String input) {

        Map<Character, Integer> output = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);


            
            
            output.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);

        }

        System.out.println(output);
	}

}

