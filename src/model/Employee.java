package model;

import java.time.LocalDate;

public abstract class Employee {

    private int id;
    private String name;
    private Gender gender;
    private LocalDate hireDate;
    private Department department;   

    public Employee(int id, String name, Gender gender, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    // ---------- getters ----------
    public int getId() { return id; }
    public String getName() { return name; }
    public Gender getGender() { return gender; }
    public LocalDate getHireDate() { return hireDate; }
    public Department getDepartment() { return department; }

    // ---------- setters ----------
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
    public void setDepartment(Department department) { this.department = department; }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", gender=" + gender +
                ", hireDate=" + hireDate +
                ", department=" + (department == null ? "none" : department.getName());
    }
}
