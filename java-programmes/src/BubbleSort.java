class  BubbleSort
{
 public static void main(String args[])
 {
  int[] a = {12,56,35,81,46,19,26};
  int temp=0;
  for(int i=0; i<a.length; i++)
  {
     int flag=0;
   for(int j=0; j<a.length-1-i; j++)
   {
    if(a[j]>a[j+1])
    {
     temp=a[j];
     a[j]=a[j+1];
     a[j+1]=temp;
     flag=1;
    }
   }
   if(flag==0)
  {break;}
  }
  for(int i=0; i<a.length; i++)
  {System.out.println(a[i]);}
 }

}