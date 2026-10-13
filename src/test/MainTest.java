package test;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("=== Employee Management System Demo ===\n");

        // 1. Create employees of every type (constructors)
        MonthlyEmployee sara = new MonthlyEmployee(1, "Sara Hassan", Gender.FEMALE,
                LocalDate.of(2018, 3, 15), 12000, 21, 10, true);
        CommissionEmployee omar = new CommissionEmployee(2, "Omar Khaled", Gender.MALE,
                LocalDate.of(2021, 7, 1), 5000, 0.05, 80000);
        HourlyEmployee mona = new HourlyEmployee(3, "Mona Adel", Gender.FEMALE,
                LocalDate.of(2023, 1, 10), 100, 48, 1.5);
        HourlyEmployee youssef = new HourlyEmployee(4, "Youssef Ali", Gender.MALE,
                LocalDate.of(2024, 9, 5), 90, 35, 1.5);

        // 2. Create a department (composition: it holds its employees)
        List<Employee> initial = new ArrayList<>();
        initial.add(sara);uyfiufiu
        initial.add(omar);
        Department sales = new Department(10, "Sales", sara, initial);

        // 3. addEmployee / relationship Employee -> Department
        sales.addEmployee(mona);
        sales.addEmployee(youssef);
        System.out.println(sales);
        System.out.println("Mona's department: " + mona.getDepartment().getName());
        System.out.println();

        // 4. Polymorphism: same call, different behavior
        System.out.println("--- Polymorphic salaries ---");
        for (Employee e : sales.getEmployees()) {
            System.out.printf("%-12s (%s): %.2f%n", e.getName(),
                    e.getClass().getSimpleName(), e.calculateSalary());
        }
        System.out.println();

        // 5. Type-specific methods
        System.out.println("--- Specific methods ---");
        System.out.printf("Omar's commission: %.2f%n", omar.calculateCommission());
        System.out.println("Sara's additional vacation days: " + sara.calculateAdditionalVacation());
        System.out.println();

        // 6. Getters and setters
        System.out.println("--- Getters / setters ---");
        System.out.println("Youssef hours before: " + youssef.getHoursWorked());
        youssef.setHoursWorked(45);
        System.out.println("Youssef hours after : " + youssef.getHoursWorked());
        System.out.printf("Youssef new salary  : %.2f%n%n", youssef.calculateSalary());

        // 7. Department operations
        sales.printAllEmployees();
        System.out.printf("%nTotal payroll: %.2f%n", sales.calculateTotalPayroll());

        System.out.println("\nFind employee 3: " + sales.findEmployee(3).getName());
        sales.removeEmployee(3);
        System.out.println("After removing employee 3, find returns: " + sales.findEmployee(3));
        System.out.println("Mona's department now: " + mona.getDepartment());
        System.out.printf("Total payroll now: %.2f%n", sales.calculateTotalPayroll());
    }
}
