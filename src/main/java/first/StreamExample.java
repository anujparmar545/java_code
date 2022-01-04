package first;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

public class StreamExample {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1,"Anuj","CS",7000,"high");
        Employee emp2 = new Employee(2,"Ankur","Mech",4865,"medium");
        Employee emp3 = new Employee(3,"Sachin","EC",2994,"low");
        Employee emp4 = new Employee(4,"Rahul","Mech",5345,"medium");
        Employee emp5 = new Employee(5,"Tillu","CS",8000,"high");
        Employee emp6 = new Employee(6,"Mohan","EC",1865,"low");

        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(emp1);allEmployees.add(emp2);allEmployees.add(emp3);
        allEmployees.add(emp4);allEmployees.add(emp5);allEmployees.add(emp6);

        ///////////////////////////////////////////////////
        // Dept wise average salary
        Map<String, Double> avgSalaryDeptWise=
                allEmployees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDept,
                                        Collectors.averagingInt(Employee::getSalary)));
        //System.out.println(avgSalaryDeptWise);
        ///////////////////////////////////////////////////
        // 2 highest salary
        //System.out.println(allEmployees.stream().sorted(comparingInt(Employee::getSalary).reversed()).map(e->e.getSalary()).skip(1).findFirst());


        ///////////////////////////////////////////////////
        // Sort emp by name then dept then reward

        Comparator<Employee> nameThenDeptThenReward =
                Comparator.comparing(Employee::getName).
                        thenComparing(Employee::getDept).
                        thenComparing(Employee::getReward);

        allEmployees.stream().sorted(nameThenDeptThenReward).collect(Collectors.toList()).forEach(System.out::println);

        ////////////////////////////////////////////////////
        //get dept wise highest salary
        Map<String, Employee> topEmployees =
                allEmployees.stream()
                        .collect(groupingBy(
                                Employee::getDept,
                                collectingAndThen(maxBy(comparingInt(Employee::getSalary)), Optional::get)
                        ));
        //System.out.println(topEmployees);
        ///////////////////////////////////////////////////
        //get dept wise highest salary
        Map<String, Employee> topEmployees1 =
                allEmployees.stream()
                        .collect(Collectors.toMap(
                                e -> e.getDept(),
                                e -> e,
                                BinaryOperator.maxBy(Comparator.comparingInt(e -> e.getSalary()))
                        ));
        //System.out.println(topEmployees1);
        ///////////////////////////////////////////////////
        //sort emp by salary
        List<Employee> sortedBySalary =
                allEmployees
                        .stream()
                        .sorted((o1,o2) -> o1.getSalary()- o2.getSalary())
                        .collect(Collectors.toList());

        //System.out.println(sortedBySalary);
        ///////////////////////////////////////////////////
        //get dept wise employees
        Map<String,List<Employee>> employeeMap
                = allEmployees.stream().collect(Collectors.groupingBy(Employee::getDept));

        //employeeMap.forEach((String key, List<Employee> empList) -> System.out.println(key +" -> "+empList));

        ///////////////////////////////////////////////////


    }
}
