package com.decipherzone.corejava;

import java.util.ArrayList;

public class Arraylist1 {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();  // created arraylist with object ar1
        al1.add(2);
        al1.add(10);
        al1.add(26);
        al1.add(50);
        al1.add(78);
        for (int x : al1)             // here x as an element to print the list
        {
            System.out.println(x);
        }
//        for(int i=0; i<al1.size(); i++)         // here pointer is used to print the elements
//        {
//            System.out.println(al1.get(i));     // pointer so get method is used to print
//        }
        al1.add(3, 23);          // add an element at a particular index
        al1.set(2, 56);                     // it replace the element at a particular index
//        al1.remove(4);
        for (int x : al1) {
            System.out.println("Print the elements of list after :" + x);
        }
        System.out.println("Check this element is present or not: " + al1.contains(50));
                // contains method is used to check weather this
               // particular element is present or not in list
        System.out.println("This also print all element of the arraylist :" + al1);
        System.out.println("Show the Size of the arraylist:" + al1.size());
        System.out.println("This also print all elements of the arraylist as:" + al1.toString());
    }
}
