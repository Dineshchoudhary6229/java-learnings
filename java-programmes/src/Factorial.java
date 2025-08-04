// factorial programme taking input from user to find its factorial.

import java.util.Scanner;
public class Factorial
{

        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);       // Scanner object

            System.out.println("Enter your no: ");
            int no = sc.nextInt();
            if(no<0)
            {
                System.out.println("NO is negative so its factorial is not possible");
            }
            else
            {
                long fact = 1;
                for (int i = no; i >=1; i--)    // for(i=1; i<=no; i++)
                {

                    fact = fact*i;

                }
                System.out.print("factorial of the "+no+" is:"+fact);
            }



        }
}
