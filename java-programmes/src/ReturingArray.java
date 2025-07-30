public class ReturingArray
{
 static int [] get()                          // creating method which retrun array 
 {
  return new int []{10,20,30,50,60,85};
 }
public static void main(String args[])
{
 int b[]=get();                             // calling method for array 
                                              // for(int i:arr)     System.out.println(i)
 for(int i = 0; i<b.length; i++)            // printing values of array 
 System.out.println(b[i]);
}

}