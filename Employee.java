package java8.streams;

import java.util.List;

public class Employee {
	private String name;
    private Integer age;
    private String address;
    private List<String> activities;
    private Integer salary;

    public Employee(String name, Integer age, String address, List<String> activities, Integer salary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.activities = activities;
        this.salary = salary;
    }

    public  List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", activities=" + activities +
                ", salary=" + salary +
                '}';
    }
}
