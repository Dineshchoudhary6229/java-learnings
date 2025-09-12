package com.decipherzone.dinesh.corejava;// Linked Hash Map --> it maintain order i.e. elements in it will be in same order inwhich we insert in it
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap1
{
    public static void main(String[] args)
    {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Mango",11);
        linkedHashMap.put("Banana",12);
        linkedHashMap.put("Grapes",13);

         // to print key values of linked hash map we use .entry.set() method with for loop in map as we
        // did in Hash map because it is a subclass of hash map so it inherit methods of it,so we extend

//        Set<Map.Entry<String, Integer>> entries =linkedHashMap.entrySet();
//         for(Map.Entry<String,Integer> entry:entries)

        // we can use above two lines of code for iterating elements of linked hash map or below only one for loop

        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet())  // to iterate elements of linked hash map we use for-each loop
        {
            System.out.println(entry.getKey()+" : "+ entry.getValue());   // give us key by getKey() and values from getValue()
        }
    }
}
