// Hashmap- There is no order in it

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo
{
    public static void main(String[] args)
    {
        HashMap<Integer, String>  map = new HashMap<>(); // hashmap created with key =integer, value=string
        map.put(1,"Atul");          //   adding key and value to hashmap
        map.put(2,"Sachin");        // to add key and value to hashmap we use put keyword
        map.put(3,"Sandeep");
        map.put(4,"Arvind");
        map.put(25,"Aryan");
//        map.put(null,"Dinesh");       // can have only one null key
//        map.put(26, null);
//        map.put(27,null);              // can have multiple null values but null key only one
//        map.put(29,null);

        System.out.println(map);    // printing hashmap

        String value1 = map.get(25);    // to access any particular key we use get method
        System.out.println(value1);

        String value2 = map.get(31);
        System.out.println(value2);   // key 31 is not present so it will give null as output

        System.out.println("\n");
        System.out.println(map.containsKey(3));    // containsKey method to find key in the map
        System.out.println(map.containsValue("Arvind"));    // checks value in the map with the help of containsValue
        System.out.println("\n");

        // if we want to start a loop in map then we use obj.keySet() method as below
        // here obj is object of map which we created when we created map
        Set<Integer> key = map.keySet();                      // we can use this for as below also
        for(int i:key)                                       //for(int i: map.keySet())
        {                                                   //{system.out.println(map.get(i));}
            System.out.println(map.get(i));
        }


        // another way to put loop in hashmap by obj.enterySet()
        // by this also we can get key and values from hashmap


        Set<Map.Entry<Integer, String>> entries = map.entrySet();    // i.e. iterating hashmap
        for(Map.Entry<Integer, String> i:entries)
                                                             // Instead we can use this also
                       // for(Map.Entry<Integer, String> i: map.entrySet())
        {
            System.out.println(i.getKey()+ " : "+ i.getValue());
            i.setValue(i.getValue().toUpperCase());               // to make all in upperCase
            System.out.println(map);                      // checking here that all string is in upper case
        }
//        map.remove(25,"ARYAN");                    // remove method to remove value from a given key and value
//        map.remove(25);                         // remove method to remove any specific key
        boolean result = map.remove(25, "ARYAN");      // to check weather removed  or not
        System.out.println("\n" + result);
        System.out.println(map);



    }
}
