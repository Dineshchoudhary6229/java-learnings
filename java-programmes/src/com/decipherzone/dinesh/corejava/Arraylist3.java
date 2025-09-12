package com.decipherzone.corejava;

import java.util.*;
class Arraylist3 {
    public static void main(String[] args) {
                                                           // Create an ArrayList
        ArrayList<String> al = new ArrayList<String>();
                                                               // Check if the ArrayList is empty
        System.out.println("Is ArrayList Empty: " + al.isEmpty());
                                                                    // Add elements to the ArrayList
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ajay");

        System.out.println("After Insertion");
                                                      // Check if the ArrayList is empty after insertion
        System.out.println("Is ArrayList Empty: " + al.isEmpty());
    }
}