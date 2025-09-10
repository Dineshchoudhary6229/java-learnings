// different ways to create arraylist

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList2 {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass().getName());
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println(list);

        list.remove(3);                                 // remove element from a particular index

        list.remove(Integer.valueOf(10));       // use WRAPPER CLASS to remove an object or a particular value
        System.out.println(list);


        //when we form arraylist with [asList] then it is fixed list in which we can't add or remove elements
        // it is nested arraylist so we can only replace elements from it
        List<String> list1 = Arrays.asList("Monday", "Tuesday", "Thursday");


        System.out.println("\n" + list1.getClass().getName());
        // list1.add("Sunday");                                  // this show an exception while run the code
        list1.set(2, "Wednesday");                               // we can only replace elements in this list
        System.out.println("\n" + list1);


        String[] array = {"Apple", "Banana", "Cherry"};               // here we make array then pass it to list
        List<String> list2 = Arrays.asList(array);                      // this is now arraylist
        System.out.println("\n" + list2.getClass().getName());         // print class name

//        list2.remove(1);                                              this give an exception
//        list2.add(2,"Orange");                                      //this also gives an exception
        list2.set(2, "Orange");                                      // it replaces element at index 2 with Orange
        System.out.println("\n" + list2);


        List<Integer> list3 = List.of(1, 2, 3, 4, 5);
        // This is un-modifiable list i.e. we can't add or remove or replace elements in it.


        //list4.add(1,29);                              // if we do so it throws en exception
        System.out.println("\n" + list3);


        //if we want to add elements in list2 then we can do by this
        List<String> list4 = new ArrayList<>(list2);
        list4.add(3, "Litchi");
        list4.add(0, "Mango");
        System.out.println("\n" + list4);


        // we can add elements of list3 by passing it as an argument to a new list and in that new list
        // we can add elements and can print a combined as below
        // as list3 is un-modifiable so we can add elements in it by this way

        List<Integer> list5 = new ArrayList<>(list3);
        list5.add(6);
        list5.add(7);
        list5.add(8);
        list5.add(9);
        System.out.println("\n" + list5);


    }
}
