package com.decipherzone.dinesh.corejava;

// typecasting -- up casting and down casting

class Animal1
{
    public void eat1()
    {
        System.out.println("munch");
    }
}

public class TypeCasting extends Animal1
{
    public void eat2()
    {
        System.out.println("wo wo woh");
    }
    public static void main(String[] args)
    {
        Animal1 obj1 = new TypeCasting();          // up casting
        TypeCasting obj2 = (TypeCasting) obj1;         // down casting
        obj1.eat1();
        obj2.eat2();
        ((TypeCasting) obj1).eat2();
        obj2.eat1();
    }
}