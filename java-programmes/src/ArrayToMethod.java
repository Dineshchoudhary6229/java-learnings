// passing array to method

public class ArrayToMethod
{
 static void  min(int b[])          // creating mehtod to pass an array as a parameter
{
 int min=b[0];
 for(int i=3;i<b.length;i++)       //traversing array elements with the help of for loop 
  {
  if (min>b[i])
  min=b[i];
  System.out.println("Array passed to method to get the minimum no and that minimum no is  :" + min);
  }}
public static void main(String args[])
{
 int a[] = {4,5,9,15};            // creating, declaring,instantiating the array a
 min(a);                          // passing array to method 
}
}