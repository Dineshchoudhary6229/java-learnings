class FirstDuplicElemntArray
{
  public static void main(String args[])
  {
    int[] a= {6,5,3,5,2,1,4};
    for(int i=0; i<a.length-1; i++)
    {
     int temp=0;
      for(int j=i+1; j<a.length; j++)
       {
         if((a[i]==a[j]) && (i != j))
          {
            System.out.println("First duplicate element in this array is :"+ a[i]);
            temp++;
            break;
          }
       }
     if(temp>0)
      {
          break;
      }
    }
  }
}