# Employee Management System

**Full name:** Ali Yasser Amer
**Student ID:** `<<< ENTER YOUR STUDENT ID HERE >>>`
**GitHub repository:** `<<< PASTE YOUR PUBLIC REPOSITORY URL HERE >>>`

## Description
A Java console application that implements a UML class diagram for an employee/payroll system. It models three kinds of employees (commission, monthly, hourly) that belong to a department, and calculates each employee's salary and the department's total payroll.

## Technologies
- Java (JDK 17 or newer; tested with JDK 21)
- No external libraries

## Main classes
| Class | Responsibility |
|---|---|
| `Gender` (enum) | `MALE`, `FEMALE` |
| `Employee` (abstract) | Common data (id, name, gender, hireDate, department) and abstract `calculateSalary()` |
| `CommissionEmployee` | Base salary + `salesAmount × commissionRate` |
| `MonthlyEmployee` | Monthly salary + bonus %, vacation days, extra vacation by years of service |
| `HourlyEmployee` | Hourly pay; hours over 40 are paid at `hourlyRate × overtimeRate` |
| `Department` | Holds a manager and a list of employees; add / remove / find / total payroll / print |
| `Main`, `test.MainTest` | Runnable demonstration |

## Design decisions (where the UML was ambiguous)
- `HourlyEmployee` constructor lists `hireDate` twice in the diagram; it is implemented once.
- `overtimeRate` is a multiplier (e.g. `1.5`) applied to `hourlyRate` for hours above 40.
- `bonusPercentage` is a percentage (10 = 10%); `commissionRate` is a fraction (0.05 = 5%).
- `calculateAdditionalVacation()` = 1 extra day per 2 completed years of service, so its result depends on today's date.
- `Employee.department` is not a constructor parameter in the diagram; it is set by `Department.addEmployee`.

## OOP concepts demonstrated
Encapsulation, inheritance, abstraction (abstract class and method), polymorphism, method overriding, enums, composition/association between `Department` and `Employee`, `this`/`super`.

## Folder structure
```
EmployeeManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Employee.java
│   │   ├── CommissionEmployee.java
│   │   ├── MonthlyEmployee.java
│   │   ├── HourlyEmployee.java
│   │   ├── Department.java
│   │   └── Gender.java
│   └── test/
│       └── MainTest.java
├── README.md
└── .gitignore
```

## Prerequisites
JDK 17 or newer (`java -version` and `javac -version` must both work).

## Compile and run
From the project root:

**Linux / macOS**
```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

**Windows (PowerShell)**
```powershell
mkdir out -Force
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out Main
```

## Example output
```
=== Employee Management System Demo ===

Department{id=10, name=Sales, manager=Sara Hassan, employeeCount=4}
Mona's department: Sales

--- Polymorphic salaries ---
Sara Hassan  (MonthlyEmployee): 13200.00
Omar Khaled  (CommissionEmployee): 9000.00
Mona Adel    (HourlyEmployee): 5200.00
Youssef Ali  (HourlyEmployee): 3150.00

--- Specific methods ---
Omar's commission: 4000.00
Sara's additional vacation days: 4
...
Total payroll: 31675.00
```
