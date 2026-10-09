package model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee e : employees) {
                addEmployee(e);
            }
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Employee getManager() { return manager; }
    public List<Employee> getEmployees() { return employees; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setManager(Employee manager) { this.manager = manager; }
    public void setEmployees(List<Employee> employees) {
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee e : employees) {
                addEmployee(e);
            }
        }
    }

    public final void addEmployee(Employee employee) {
        if (employee != null && !employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(int employeeId) {
        Employee found = findEmployee(employeeId);
        if (found != null) {
            employees.remove(found);
            found.setDepartment(null);
        }
    }

    public Employee findEmployee(int employeeId) {
        for (Employee e : employees) {
            if (e.getId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public void printAllEmployees() {
        System.out.println("Employees of " + name + ":");
        if (employees.isEmpty()) {
            System.out.println("  (no employees)");
        }
        for (Employee e : employees) {
            System.out.println("  " + e);
        }
    }

    @Override
    public String toString() {
        return "Department{id=" + id +
                ", name=" + name +
                ", manager=" + (manager == null ? "none" : manager.getName()) +
                ", employeeCount=" + employees.size() + "}";
    }
}
