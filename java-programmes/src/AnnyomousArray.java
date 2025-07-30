// passing annyomous array to method 

public class AnnyomousArray
{
 static void display(int b[])
 {
  for (int i: b)                                                                      //for(int i=0; i<b.length; i++)
  System.out.println("Passing annymous array directly to the method :" + i);       // sout(b[i]);
 }
public static void main(String args[])
{
 display(new int[]{4,5,18,63});
}
}