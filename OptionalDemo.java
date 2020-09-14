package java8; 


import java.util.Optional; 


public class OptionalExample { 
    public static void main(String[] args) { 
        optionalOf(); 
         optionalOfNullAble(); 
         optionalOfMapOrElse(); 
         optionalOfMapOrElseGet(); 
     } 
 
    /**
     * Returns an {@code Optional} with the specified present non-null value.
     *
     * @param <T> the class of the value
     * @param value the value to be present, which must be non-null
     * @return an {@code Optional} with the value present
     * @throws NullPointerException if value is null
     */
     private static void optionalOf() { 
         Optional<Employee> optionalEmployee = Optional.of(LamdaExample.getEmployees().get(0)); 
 

         if(optionalEmployee.isPresent()) 
         System.out.println("optionalOf ::"+optionalEmployee.get()); 
 

         else 
             System.out.println("Employee not found"); 
     } 
 
     /**
      * Returns an {@code Optional} describing the specified value, if non-null,
      * otherwise returns an empty {@code Optional}.
      *
      * @param <T> the class of the value
      * @param value the possibly-null value to describe
      * @return an {@code Optional} with a present value if the specified value
      * is non-null, otherwise an empty {@code Optional}
      */
     private static void optionalOfNullAble() { 
         Optional<Employee> optionalEmployee = Optional.ofNullable(null); 
         // OptionalOfNullable will handle the null condition also 
         if(optionalEmployee.isPresent()) 
             System.out.println("optionalOfNullAble  ::"+optionalEmployee.get()); 
 

         else 
             System.out.println("optionalOfNullAble  ::" +"Employee not found"); 
     } 
 
     /**OrElse
      * Return the value if present, otherwise return {@code other}.
      *
      * @param other the value to be returned if there is no value present, may
      * be null
      * @return the value, if present, otherwise {@code other}
      */
     private static void optionalOfMapOrElse() { 
         Optional<Employee> optionalEmployee = Optional.of(LamdaExample.getEmployees().get(0)); 
         // OptionalOfNullable will handle the null condition also 
         System.out.println("optionalOfMapOrElse() :: "+optionalEmployee.map(Employee::getSalary).orElse(0)); 
     } 
 
     /**
      * Return the value if present, otherwise invoke {@code other} and return
      * the result of that invocation.
      *
      * @param other a {@code Supplier} whose result is returned if no value
      * is present
      * @return the value if present otherwise the result of {@code other.get()}
      * @throws NullPointerException if value is not present and {@code other} is
      * null
      */
     private static void optionalOfMapOrElseGet() { 
         Optional<Employee> optionalEmployee = Optional.of(LamdaExample.getEmployees().get(0)); 
         // OptionalOfNullable will handle the null condition also 
         System.out.println("optionalOfMapOrElseGet() ::" + optionalEmployee.map(Employee::getSalary).orElseGet(() -> 50)); 
     } 
     
     
     /*Difference between 
    orElse() will always call the given function whether you want it or not, regardless of Optional.isPresent() value
    •orElseGet() will only call the given function when the Optional.isPresent() == false
     
     
     +——————————————————————————————————————————————————————————————————+——————————————+
     |           Optional.isPresent()                                   | true | false |
     +——————————————————————————————————————————————————————————————————+——————————————+
     | findMyPhone(int phoneId).orElse(buyNewExpensivePhone())          |   X  |   X   |
     +——————————————————————————————————————————————————————————————————+——————————————+
     | findMyPhone(int phoneId).orElseGet(() -> buyNewExpensivePhone()) |      |   X   |
     +——————————————————————————————————————————————————————————————————+——————————————+

     When optional.isPresent() == false, there is no difference between two ways. However, when optional.isPresent() == true, orElse() always calls the subsequent function whether you want it or not. 

     Finally, test case used is as below:

     Result: 
     ------------- Scenario 1 - orElse() --------------------
       1.1. Optional.isPresent() == true
         Going to a very far store to buy a new expensive phone
         Used phone: MyCheapPhone

       1.2. Optional.isPresent() == false
         Going to a very far store to buy a new expensive phone
         Used phone: NewExpensivePhone

     ------------- Scenario 2 - orElseGet() --------------------
       2.1. Optional.isPresent() == true
         Used phone: MyCheapPhone

       2.2. Optional.isPresent() == false
         Going to a very far store to buy a new expensive phone
         Used phone: NewExpensivePhone*/


 } 

