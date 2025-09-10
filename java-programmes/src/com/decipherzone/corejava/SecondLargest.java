class SecondLargest
{
 public static void main(String[] args)
 {
  int[] a = {15,3,46,84,61,59,35};
  int temp;
  for(int i=0; i<a.length; i++)
  {
   for(int j=i+1; j<a.length; j++)
   {
    if(a[i]<a[j])
    {
    temp=a[i];
    a[i]=a[j];
    a[j]=temp;
     }
  }
 }
for(int i=0;i<a.length; i++)

{
 System.out.println(a[i]);
 }
System.out.println("Second largest element of array is:\n"+ a[1]);
}

}