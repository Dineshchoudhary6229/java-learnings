import java.util.Scanner;

public class Factorial_Recursion
{
    public static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        else
        {
            return n*factorial(n-1);
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no :");
        int no =scanner.nextInt();
        if(no<0)
        {
            System.out.println("The no is negative ,it's factorial is not possible");
        }
        else
        {
            int result = factorial(no);
            System.out.println("Factorial of the "+no+" is : " + result);
        }
    }
}
