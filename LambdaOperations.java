package java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toSet;

public class LambdaOperations {

	
	
	static ArrayList<Employee> allEmployees = new ArrayList<>();

	public static void main(String[] args) {
		getEmployees();
        getListOfAddress();
		        getSetOfAddress();
	        useOfFlatMap();
//		        getSortedActivities();
//		        getDistinctActivities();
	        getSortByName();
//		        getSortByAge();
//		        getFilterByAge();
//		        getFilterByName();
//		        getFilterByNameAndAge();
//		        getReduceFunctionOnSalary();
//		        getReduceFunctionOnAvgSalary();
//		        getMaxSalariedEmployee();
//		       getJoinedEmployeeByName();
//		         getJoinedEmployeeByNameWithDeliMeter();
//		        getJoinedEmployeeByNameWithDeliMeterAndWithSuffix_Prefix();
//		        getCountOfEmployee();
//		        getCountOfEmployeeWithFilter();
//		        getMappingOfEmployee();
//		        getMinBy_Employee();
//		         getMaxBy_Employee();
//		         getAverageSalaryOfEmployees();
//		         getSumOfSalaryOfEmployees();
//		         getGroupByAddressEmployees();
//		         getCustomGroupBySalaryEmployees();
//		         getCustomGroupByMore();
//		        // getGroupByAndMax();
//		        getGroupByAndCount();
//		         getGroupByAndCountOnTempArray();
		getPartition();

	}

	private static void getListOfAddress() {
		List<String> result = allEmployees.stream().map(Employee::getAddress).collect(Collectors.toList());
		System.out.println("getListOfAddress :: "+result);
	}

	private static void getSetOfAddress() {
		Set<String> result = allEmployees.stream().map(Employee::getAddress).collect(toSet());
		System.out.println("getSetOfAddress :: "+result);
	}

	private static void useOfFlatMap() {
		List<String> result = allEmployees.stream().map(Employee::getActivities).flatMap(List::stream)
				.collect(Collectors.toList());
		System.out.println("useOfFlatMap :: "+result);
	}

	private static void useOfFlatMapSet() {
		Set<String> result = allEmployees.stream().map(Employee::getActivities).flatMap(List::stream).collect(toSet());
		System.out.println("useOfFlatMapSet :: "+result);
	}

	private static void getSortedActivities() {
		List<String> result = allEmployees.stream().map(Employee::getActivities).flatMap(List::stream).sorted()
				.collect(Collectors.toList());
		System.out.println("getSortedActivities :: "+result);
	}

	private static void getDistinctActivities() {
		long uniqueRecords = allEmployees.stream().map(Employee::getActivities).flatMap(List::stream).distinct().count();

		System.out.println("getDistinctActivities :: "+uniqueRecords);
	}

	private static void getSortByName() {
		List<Employee> result = allEmployees.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		 System.out.println("getSortByName ::"+result);
	}

	private static void getSortByAge() {

//		        List<Employee> result = allEmployees
//		                .stream()
//		                .sorted(Comparator.comparing(Employee::getAge).reversed())
//		                .collect(Collectors.toList());
//		        result.forEach(System.out::println);

		List<Employee> result = allEmployees.stream().sorted(Comparator.comparing(Employee::getAddress))
				.sorted(Comparator.comparing(Employee::getAge)).sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		 System.out.println("getSortByAge ::"+ result);
	}

	private static void getFilterByAge() {
		List<Employee> result = allEmployees.stream().filter(employee -> employee.getAge() >= 30)
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		System.out.println("getFilterByAge :: "+result);
	}

	private static void getFilterByName() {
		List<Employee> result = allEmployees.stream().filter(employee -> employee.getName().equalsIgnoreCase("amol"))
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		System.out.println("getFilterByName ::"+result);
	}

	private static void getFilterByNameAndAge() {
		List<Employee> result = allEmployees.stream().filter(employee -> !employee.getName().equalsIgnoreCase("amol"))
				.filter(employee -> employee.getAge() != 30).collect(Collectors.toList());
		result.forEach(System.out::println);
		 System.out.println("getFilterByNameAndAge:: "+result);
	}

	private static void getReduceFunctionOnSalary() {
		Optional<Integer> result = allEmployees.stream().map(Employee::getSalary).reduce((a, b) -> Math.max(a, b));
		System.out.println("getReduceFunctionOnSalary :: "+result.get());
	}

	private static void getReduceFunctionOnAvgSalary() {

		Optional<Integer> result = allEmployees.stream().map(Employee::getSalary).reduce((a, b) -> (a + b) / 2);
		System.out.println("getReduceFunctionOnAvgSalary ::"+result.get());
	}

	// to find max salaried employee , we can use reduce
	private static void getMaxSalariedEmployee() {

		Optional<Employee> result = allEmployees.stream().reduce((e1, e2) -> {
			return e1.getSalary() > e2.getSalary() ? e1 : e2;
		});
		System.out.println("getMaxSalariedEmployee :: "+result.get());
	}

	private static void getJoinedEmployeeByName() {

		String result = allEmployees.stream().map(Employee::getName).collect(joining());
		System.out.println("getJoinedEmployeeByName ::"+result);
	}

	private static void getJoinedEmployeeByNameWithDeliMeter() {

		String result = allEmployees.stream().map(Employee::getName).collect(joining(","));
		System.out.println("getJoinedEmployeeByNameWithDeliMeter ::"+result);
	}

	private static void getJoinedEmployeeByNameWithDeliMeterAndWithSuffixPrefix() {

		String result = allEmployees.stream().map(Employee::getName).collect(joining(",", "{", "}"));
		System.out.println("getJoinedEmployeeByNameWithDeliMeterAndWithSuffixPrefix ::"+result);
	}

	private static void getCountOfEmployee() {
		long result = allEmployees.stream().collect(counting());
		System.out.println("getJoinedEmployeeByNameWithDeliMeterAndWithSuffixPrefix ::"+result);
	}

	private static void getCountOfEmployeeWithFilter() {
		long result = allEmployees.stream().filter(employee -> employee.getSalary() > 60000).collect(counting());
		System.out.println("getCountOfEmployeeWithFilter ::"+result);
	}

	private static void getMappingOfEmployee() {

//		        List<String> result = allEmployees
//		                .stream()
//		                .collect(mapping(Employee::getName,toList()));
//		        System.out.println(result);

		Set<String> result = allEmployees.stream().collect(mapping(Employee::getName, toSet()));

		System.out.println("getMappingOfEmployee ::"+result);
	}

	private static void getMinByEmployee() {
		Optional<Employee> result = allEmployees.stream().collect(minBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("getMinByEmployee ::"+result.get());
	}

	private static void getMaxByEmployee() {
		Optional<Employee> result = allEmployees.stream().collect(maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("getMaxByEmployee ::"+result.get());
	}

	private static void getAverageSalaryOfEmployees() {
		Double result = allEmployees.stream().collect(averagingDouble(Employee::getSalary));
		System.out.println("getAverageSalaryOfEmployees ::"+result);
	}

	private static void getSumOfSalaryOfEmployees() {
		Long result = allEmployees.stream().collect(summingLong(Employee::getSalary));
		System.out.println("getSumOfSalaryOfEmployees ::"+result);
	}

	private static void getGroupByAddressEmployees() {
		Map<String, List<Employee>> result = allEmployees.stream().collect(groupingBy(Employee::getAddress));
		System.out.println("getGroupByAddressEmployees ::"+result);
	}

	private static void getCustomGroupBySalaryEmployees() {
		Map<String, List<Employee>> result = allEmployees.stream()
				.collect(groupingBy(employee -> employee.getSalary() < 80000 ? "LOW SALARY" : "HIGH SALARY"));
		System.out.println("getCustomGroupBySalaryEmployees ::"+result);
	}

	private static void getCustomGroupByMore() {
		Map<String, Double> result = allEmployees.stream().collect(
				groupingBy(employee -> employee.getAddress(), averagingDouble(employee -> employee.getSalary())));

		System.out.println("getCustomGroupByMore ::"+result);
	}

	private static void getGroupByAndMax() {
		Map<String, Optional<Employee>> result = allEmployees.stream().collect(
				groupingBy(employee -> employee.getAddress(), maxBy(Comparator.comparing(Employee::getSalary))));

	System.out.println("getGroupByAndMax ::"+result);
		
	}

	private static void getGroupByAndCount() {
		Map<String, Long> result = allEmployees.stream()
				.collect(groupingBy(employee -> employee.getAddress(), counting()));

		System.out.println("getGroupByAndCount ::"+result);
		
	}

	private static void getGroupByAndCountOnTempArray() {
		Map<String, Long> result = asList(
				new String[] { "Adam", "Andrew", "Kris", "Nicolay", "James", "Andrew", "Tom", "James" }).stream()
						.sorted(Comparator.reverseOrder()).collect(groupingBy(String::toString, counting()));

		System.out.println("getGroupByAndCountOnTempArray ::"+result);
		
	}

	private static void getPartition() {
		Predicate<Employee> predicate = employee -> employee.getSalary() > 70000;
		Map<Boolean, List<Employee>> result = allEmployees.stream().collect(partitioningBy(predicate));

		System.out.println("getPartition ::"+result);
	}

	public static List<Employee> getEmployees() {
		allEmployees.add(new Employee("Adam", 30, "NY", asList(new String[] { "cricket", "badminton", "chess" }),
				120000));
		allEmployees.add(
				new Employee("Andrew", 28, "LONDON", asList(new String[] { "badminton", "chess", "gaming" }), 100000));
		allEmployees.add(new Employee("Kris", 31, "AUS",
				asList(new String[] { "cricket", "badminton", "football" }), 99999));
		allEmployees.add(new Employee("Tom", 31, "Eng", asList(new String[] { "badminton", "ludo" }), 110000));
		allEmployees.add(
				new Employee("Nicolay", 28, "Vegas", asList(new String[] { "cricket", "badminton", "chess" }), 50000));
		allEmployees
				.add(new Employee("James", 30, "SA", asList(new String[] { "cricket", "badminton", }), 90000));
		allEmployees.add(new Employee("Anderson", 30, "NZ", asList(new String[] { "cricket", "chess" }), 56000));


		return allEmployees;
	}

}
