package com.decipherzone.corejava;

public class Student1
{
  String name;                                         // instance variable
  String city;                                         // instance variable
  int roll_no;                                         // instance variable

    Student1(String name ,  String city, int roll_no )         // argument local variables
    {
      this.name = name;                                // this keyword is used to differentiate local argument
      this.city = city;                                // to instance variable
      this.roll_no = roll_no;
    }

    public static void main(String[] args)
    {
      Student1 s1 = new Student1("Anil","Jaipur",01);
      Student1 s2 = new Student1("Yash","Delhi",02);
      System.out.println(s1);                      //compiler here write s1.toString() and then execute it.
      System.out.println(s2);                      // compiler here write s2.toString() and execute it
    }
}
