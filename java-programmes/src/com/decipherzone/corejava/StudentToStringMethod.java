public class StudentToStringMethod
{
 String name;                                        // instance variable
 String city;                                        // instance variable
 int roll_no;                                        // instance variable
    StudentToStringMethod(String fullname, String downtown, int rl_n)
    {
        name= fullname;                            // here we dont use this keyword becoz here local agrument
        city = downtown;                           // variables and instance varibles are different that's why
        roll_no = rl_n;
    }
    public String toString()                        // toString() method overriding
    {
        return roll_no+", "+name+", "+city;
    }

    public static void main(String[] args)
    {
        StudentToStringMethod s1 = new StudentToStringMethod("Anil","Jaipur",101);
        StudentToStringMethod s2 = new StudentToStringMethod("Yash","Delhi",102);
        System.out.println(s1);                            // compiler here write s1.toString() so it call toString method
        System.out.println(s2);                            // at line 12 and return the values of name, city , roll_no same for
                                                           // for object s2
    }
}
