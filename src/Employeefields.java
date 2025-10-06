//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// File: Employeefields.java
// Immutable Employee Example

// Immutable Employee Class
final class Employee {
    private final int id;
    private final String name;
    private final double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                " }";
    }
}

// Test Class with main()
public class Employeefields {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Vishnu", 50000.0);

        // Print details
        System.out.println(emp);

        // Employee remains unchanged
        System.out.println("Employee details remain unchanged: " + emp);
    }
}



