class SecondLargest1
{
 public static void main(String[] args)
 {
  int largest=Integer.MIN_VALUE;
  int second_largest=Integer.MIN_VALUE;
  int[] a = {5,55,65,12,56,16,49,79,18,9,4,99,99,99};
  for(int i=0; i<a.length; i++)
  {
   if(a[i]>largest)
   {
    second_largest=largest;
    largest=a[i];
   }
   else if(a[i]>second_largest && a[i]!=largest)
   {
    second_largest=a[i];
   }
  }
   if(second_largest==Integer.MIN_VALUE)
   {
     System.out.println("There is no second largest element");
   }
  else
   {
    System.out.println("Second largest element of array is :"+ second_largest);
   }
 }
}