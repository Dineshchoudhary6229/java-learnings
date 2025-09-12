package com.decipherzone.corejava;

import java.util.Scanner;

public class PrimeNo
{
    public static boolean isPrime(int x)
    {
        int res= 0;
        for(int i=1;i<x/2;i++)
        {
            if(x%i==0)
            {
                res++;
            }
        }
        return res==1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no to check: ");
        int x=sc.nextInt();

        System.out.println( isPrime(x));

    }
}
