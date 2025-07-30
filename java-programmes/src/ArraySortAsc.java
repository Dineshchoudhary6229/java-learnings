class ArraySortAsc
{
 public static void main(String args[])
 {
  int temp=0;
  int[] arr= new int[]{5,1,58,29,85,64,46};      // initialisation of  array
  for(int i=0; i<arr.length; i++)
  {
   System.out.println(arr[i]);
  }
 for(int i=0; i<arr.length; i++)         // sort the array in ascending order
 {
  for(int j=i+1; j<arr.length; j++)
  {
   if(arr[i]>arr[j])
    {
     temp=arr[i];
     arr[i]=arr[j];
     arr[j]=temp;
    }
  }
 }
System.out.println("Sorted array is: ");
for(int i=0; i<arr.length; i++)              // Display sorted element of array
{ 
 System.out.println(arr[i]);
}
 }
}