public class Student_ToStringMethod
{
  String name;
  String city;
  int roll_no;
  float fee;
    Student_ToStringMethod(int roll_no, String name, String city)
    {
        this.name= name;
        this.city = city;
        this.roll_no =roll_no;
        this.fee = fee;
    }
    public String display()
    {
        System.out.println(roll_no+" "+name+" "+city);
        return " ";
    }
    Student_ToStringMethod(int roll_no,String name, String city,float fee)
    {
        this.roll_no =roll_no;
        this.name =name;
        this.city = city;
        this.fee =fee;
    }
    public String toString()
    {
        return roll_no+" "+name+" "+fee+" "+city;
    }

    public static void main(String[] args)
    {
        Student_ToStringMethod std1 = new Student_ToStringMethod(101,"Pawan","jaipur");
        Student_ToStringMethod std2 = new Student_ToStringMethod(102,"Sachin","Ajmer");
        Student_ToStringMethod std3 = new Student_ToStringMethod(103,"Arvind","Bikaner",7000);
        Student_ToStringMethod std4 = new Student_ToStringMethod(104,"Atul","NewYork",10000);
        std1.display();
        std2.display();
        System.out.println(std3);
        System.out.println(std4);
    }
}
