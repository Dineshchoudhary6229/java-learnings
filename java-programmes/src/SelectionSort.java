class SelectionSort
{
 public static void main(String args[])
 {
  int[] a = {38,56,15,46,84,72,11,28,9,46};    //array declared ,created, instantiated
  int temp=0;
  int min;
  for(int i=0; i<a.length; i++)               //for array elements 
  {
   min=i;
   for(int j=i+1; j<a.length; j++)          // start with the i+1 element of the array
   {
    if(a[j]<a[min])                         // check weather the 2nd element of the array is smaller than the 1st element of the array
    {
     min=j;                                 //if the condition of the IF statement is true then 
    }
   }
  temp=a[i];                                //for swapping of elements
  a[i]=a[min];                              //for swapping of elements
  a[min]=temp;                              //for swapping of elements
  }
 for(int i=0; i<a.length; i++)               // to print sorted elements of array
 System.out.println(a[i] +" ");
 }
}