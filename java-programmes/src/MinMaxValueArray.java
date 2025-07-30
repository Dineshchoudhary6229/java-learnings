class MinMaxValueArray
{
 public static void main(String args[])
 {
  int[] a = {5,1,2,6,4,3};
  int max=a[0];
  for(int i=1; i<a.length; i++)
  
  {
   if(a[i]>max)
   {
    max=a[i];
    System.out.println("Biggest element in the array is:"+ max);
   }
  }
  int min=a[0];
  for(int j=1; j<a.length; j++)
  
  {
   if(a[j]<min)
   {
    min=a[j];
    System.out.println("Smallest element in the given array is :"+ min);
   }
  }
 }
}