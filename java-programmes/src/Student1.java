public class Student
{
  String name;                                         // instance varaible
  String city;                                         // instance variabele
  int roll_no;                                         // instance variable

    Student(String name ,  String city, int roll_no )         // argument lcoal variables
    {
      this.name = name;                                // this keyword is used to differenciate local argument
      this.city = city;                                // to instance variable
      this.roll_no = roll_no;
    }

    public static void main(String[] args)
    {
      Student s1 = new Student("Anil","Jaipur",01);
      Student s2 = new Student("Yash","Delhi",02);
      System.out.println(s1);                      //compiler here write s1.toString() and then execute it.
      System.out.println(s2);                      // compiler here write s2.toString() and execute it
    }
}
