// Abstract class
abstract class Employee1 {
    private String name;
    private int employeeId;

    public Employee1(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    // Abstract method
    abstract void calculatePay();
}

// FullTimeEmployee class
class FullTimeEmployee1 extends Employee1 {
    private double salary;

    public FullTimeEmployee1(String name, int employeeId, double salary) {
        super(name, employeeId);
        this.salary = salary;
    }

    @Override
    void calculatePay() {
        System.out.println("FullTimeEmployee Pay: " + salary);
        
    }
}

// Contractor class
class Contractor1 extends Employee1 {
    private double hourlyRate;
    private int hoursWorked;

    public Contractor1(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    void calculatePay() {
        System.out.println("Contractor Pay: " + (hourlyRate * hoursWorked));
    }
}

// Usage
public class CalculatePay {
    public static void main(String[] args) {
        Employee1 fullTimeEmployee = new FullTimeEmployee1("Alice", 101, 60000);
        fullTimeEmployee.calculatePay(); // Output: FullTimeEmployee Pay: 60000.0

        Employee1 contractor = new Contractor1("Bob", 102, 50, 160);
        contractor.calculatePay(); // Output: Contractor Pay: 8000.0
    }
}