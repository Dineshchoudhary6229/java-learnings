class CloneArray
{
 public static void main(String args[])
 {
  int arr[]= {10,50,46,89,16};
  System.out.println("Printing original array:");
  for(int i: arr)
  System.out.println(i);
  System.out.println("Printing clone array:");
  int x[]=arr.clone();
  for(int i: x)
  System.out.println(i);
  System.out.println("Are both equal");
  System.out.println(arr==x);
 }
}