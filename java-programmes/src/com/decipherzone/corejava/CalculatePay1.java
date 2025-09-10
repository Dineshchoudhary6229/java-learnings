abstract class  Employee
{
    private String name;
    private int employeeId;
    public Employee(String name, int employeeId)
    {
        this.name=name;
        this.employeeId=employeeId;
    }
    public String getname()
    {
        return name;
    }
    public int getemployeeId()
    {
        return employeeId;
    }
    abstract void calculatepay();
}
class FullTimeEmployee extends Employee
{
    private double salary;
    public FullTimeEmployee(String name, int employeeId, double salary)
    {
        super(name, employeeId);
        this.salary=salary;
    }
    void calculatepay()
    {
        System.out.println("FullTimeEmployee pay:"+salary);
    }
}
class Contractor extends Employee
{
    private double hourlyRate;
    private int hoursWorked;
    public Contractor(String name,int employeeId,  double hourlyRate,int hoursWorked)
    {
        super(name, employeeId);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    void calculatepay()
    {
        System.out.println("Contractor pay:"+(hourlyRate*hoursWorked));
    }
}
public class CalculatePay1
{
    public static void main(String args[])
    {
        Employee obj1= new FullTimeEmployee("Atul",1001,25000);
        obj1.calculatepay();
        Employee obj2=new Contractor("Bob",102,50,160);
        obj2.calculatepay(); 
    }
}