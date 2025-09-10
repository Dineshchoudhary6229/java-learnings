class DupliElementArray
{
 public static void main(String args[])
{
int[] a={5,1,6,8,2,1,3,2};
for(int i=0; i<a.length; i++)
{
 for(int j=i+1; j<a.length; j++)
 {
    if(a[i]==a[j] && i != j)
     {
       System.out.println("Duplicate element in array are:"+ a[i]);
     }
 }
}
}}