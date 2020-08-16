package java8.streams;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		  //optionalOf();
	       // optionalOfNullAble();
	        //optionalOfMapOrElse();
	        optionalOfMapOrElseGet();
	    }

	    private static void optionalOf() {
	        Optional<Employee> optionalEmployee = Optional.of(LambdaOperations.getEmployees().get(0));

	        if(optionalEmployee.isPresent())
	        System.out.println("optionalOf  :: "+optionalEmployee.get());

	        else
	            System.out.println("optionalOf:: "+"Employee not found");
	    }

	    private static void optionalOfNullAble() {
	        Optional<Employee> optionalEmployee = Optional.ofNullable(null);
	        // OptionalOfNullable will handle the null condition also
	        if(optionalEmployee.isPresent())
	            System.out.println("optionalOfNullAble :: "+optionalEmployee.get());

	        else
	            System.out.println("optionalOfNullAble ::"+"Employee not found");
	    }

	    private static void optionalOfMapOrElse() {
	        Optional<Employee> optionalEmployee = Optional.of(LambdaOperations.getEmployees().get(0));
	        System.out.println("optionalOfMapOrElse ::"+optionalEmployee.map(Employee::getSalary).orElse(0));
	    }

	    private static void optionalOfMapOrElseGet() {
	        Optional<Employee> optionalEmployee = Optional.of(LambdaOperations.getEmployees().get(0));
	        System.out.println("optionalOfMapOrElseGet :: "+optionalEmployee.map(Employee::getSalary).orElseGet(() -> 50));
	    }
}
