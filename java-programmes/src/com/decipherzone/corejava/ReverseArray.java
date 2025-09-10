class ReverseArray
{
 public static void main(String args[])
{
 int [] arr = new int []{1,2,3,4,5};
 System.out.println("Original Array:");
 for(int i : arr)
 {
  System.out.println(i);
 }
 System.out.println("Array in Reverse order:");
 for(int i=arr.length-1; i>=0; i--)
 {
  System.out.println(arr[i]+ " ");
 }
}
}