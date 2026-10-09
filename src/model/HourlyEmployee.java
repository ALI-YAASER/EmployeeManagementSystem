package model;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

    private static final double REGULAR_HOURS_LIMIT = 40.0;

    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate;   

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public double getOvertimeRate() { return overtimeRate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public void setOvertimeRate(double overtimeRate) { this.overtimeRate = overtimeRate; }

    @Override
    public double calculateSalary() {
        if (hoursWorked <= REGULAR_HOURS_LIMIT) {
            return hoursWorked * hourlyRate;
        }
        double overtimeHours = hoursWorked - REGULAR_HOURS_LIMIT;
        return REGULAR_HOURS_LIMIT * hourlyRate + overtimeHours * hourlyRate * overtimeRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString() +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                ", overtimeRate=" + overtimeRate +
                ", salary=" + String.format("%.2f", calculateSalary()) + "}";
    }
}
