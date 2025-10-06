import java.util.*;

class student {
    int id;
    String name;
    double salary;

    public student(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class SortEmployeesExample {
    public static void main(String[] args) {
        // Step 1: Create list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vishnu", 65000));
        employees.add(new Employee(2, "Aarav", 45000));
        employees.add(new Employee(3, "Meera", 80000));
        employees.add(new Employee(4, "Kiran", 55000));

        System.out.println("Before Sorting:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Step 2: Sort by salary using Comparator (Lambda Expression)
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println("\nAfter Sorting by Salary (Ascending):");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Step 3 (Optional): Sort in descending order
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

        System.out.println("\nAfter Sorting by Salary (Descending):");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
