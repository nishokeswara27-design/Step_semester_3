package oop.assigment_problems;

/**
 * F2. Extending Employee Without Touching It
 * Topic: Inheritance, Encapsulation, Extensibility, instanceof dispatch
 */
class Employee {
    private String empId;
    private String empName;
    private double salary;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}

class ManagerEmployee extends Employee {
    private double teamBonus;

    public ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    public double effectiveSalary() {
        return getSalary() + teamBonus;
    }

    public double getTeamBonus() {
        return teamBonus;
    }
}

class InternEmployee extends Employee {
    private double stipendCap;

    public InternEmployee(String empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    public double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }

    public double getStipendCap() {
        return stipendCap;
    }
}

public class EmployeeExtensibility {
    public static void main(String[] args) {
        Employee plain = new Employee("E101", "Plain Employee", 40000.0);
        ManagerEmployee manager = new ManagerEmployee("E102", "Manager Employee", 70000.0, 8000.0);
        InternEmployee intern = new InternEmployee("E103", "Intern Employee", 12000.0, 10000.0);

        Employee[] employees = new Employee[] { plain, manager, intern };

        for (Employee emp : employees) {
            if (emp instanceof ManagerEmployee) {
                ManagerEmployee m = (ManagerEmployee) emp;
                System.out.println("Manager effective pay: Rs " + m.effectiveSalary());
            } else if (emp instanceof InternEmployee) {
                InternEmployee i = (InternEmployee) emp;
                System.out.println("Intern effective pay: Rs " + i.effectiveSalary());
            } else {
                System.out.println("Plain employee pay: Rs " + emp.getSalary());
            }
        }
    }
}
