// Finding duplicate value in array using Hash Table

import java.util.Map;                                    // To call Map //
import java.util.HashMap;                                // To call HashMap//
import java.util.Set;
class DupliElementArray2
{
  public static void main(String args[])
  {
    int[] arr ={3,5,4,3,2,2,1,3};
    Map<Integer,Integer>hm = new HashMap<>();
    for(int no: arr)
    {
       Integer count=hm.get(no);                                        // get method take input in integer form //
       if(count==null)
       {
          hm.put(no,1);
       }
       else
        {
          count=count+1;
          hm.put(no,count);
        }
    }
    System.out.print("Duplicate elements are:");
    Set<Map.Entry<Integer,Integer>>es=hm.entrySet();                  //Map.Entery is used when we want to get key and value from Map//
    for(Map.Entry<Integer,Integer>me:es)                               //and entery is sub interface of map and es is reference of set//
    {                                                                   // me is take as a variable//
      if(me.getValue()>1)
      {
        System.out.print(me.getKey()+" ");
      }
    }
}
}