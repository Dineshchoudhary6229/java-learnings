package com.decipherzone.corejava;






















/*
 Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks :" );
int marks= sc.nextInt();

        if (marks>=90)
        {
        System.out.println("Grade A");
        }
                else if(marks>=75)
        {
        System.out.println("Grade B");
        }
                else if(marks >=60)
        {
        System.out.println("Grade C");
        }
                else
                {
                System.out.println("Fail");
        }
        */



/* switch case can be used with these: ( int, byte, char ,short , string,Enum type)
Scanner sc = new Scanner(System.in);
        System.out.println("Enter day of week :");
        int day = sc.nextInt();
        switch (day)
        {
            case 1:
                System.out.println("Today is Monday");
                break;
            case 2:
                System.out.println("Today is Tuesday");
                break;
            case 3:
                System.out.println("Today is Wednesday");
                break;
            case 4:
            System.out.println("Today is Thursday");
                break;
            case 5:
            System.out.println("Today is Friday");
                break;
            case 6:
            System.out.println("Today is Saturday");
                break;
            case 7:
            System.out.println("Today is Sunday");
                break;
        }

 */

/* while loop
        int i = 0;                                              /initialization
        while(i<=50)                                            /condition
        {
            System.out.println(i );
            i++;      / i= i+1;                                   /update
        }

        do-while loop--> it will run at least one time even condition false
        in it we give condition later and code in do loop

        int b=100;                                                  /initialization
        do {
            System.out.println(b);
            b++;                                                   /update
        }
        while (b<=8);                                              /condition
 */


/* typecasting -- up casting and down casting
class Animal1
{
    public void eat1()
    {
        System.out.println("munch");
    }
}

public class Testing extends Animal1
{
    public void eat2()
    {
        System.out.println("wo wo woh");
    }
    public static void main(String[] args)
    {
        Animal1 obj1 = new Testing();          // up casting
        Testing obj2 = (Testing) obj1;         // down casting
        obj1.eat1();
        obj2.eat2();
        ((Testing) obj1).eat2();
        obj2.eat1();
    }
}
*/




/*

 */