class KthLargestInArray
{
 public static void main(String[] args)
 {
  int[] a={5,2,1,6,4,3};
  int k=4;
  for(int i=0; i<a.length-1; i++)
  {
   for(int j=i+1; j<a.length; j++)
   {
    int temp;
    if(a[i]<a[j])
    {
     temp=a[i];
     a[i]=a[j];
     a[j]=temp;
    }
   }
   if(i==k-1)
   {System.out.println(k+ "K-th largest element is "+a[i]);}
  }
  System.out.println("-------------------------");
  for(int i=0; i<a.length; i++)
  {System.out.println(a[i]);}
 }
}