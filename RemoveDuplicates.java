package java8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LinkedList<Integer> duplicateElements = new LinkedList<Integer>();
	        duplicateElements.add(1);
	        duplicateElements.add(2);
	        duplicateElements.add(3);
	        duplicateElements.add(4);
	        duplicateElements.add(1);
	        duplicateElements.add(3);
	        duplicateElements.add(1);
	        
	        List<Integer> collect = duplicateElements.stream().distinct().collect(Collectors.toList());
	
	        collect.forEach(System.out::println);
	        
	        System.out.println("=================");
			LinkedList<Integer> uniqueList = new LinkedList<Integer>();
			for (Integer e : duplicateElements) {
				if (!uniqueList.contains(e)) {
					uniqueList.add(e);
				}
			}
			System.out.println("Unique List in LinkedList: " + uniqueList);

		}

	}
