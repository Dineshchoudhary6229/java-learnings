import java.util.*;

public class TreeSortArray 
 {
    public static void main(String[] args) 
{
        int[] arr = {5, 1, 4, 1,4,3,2, 3};

                                                                                    // TreeSet automatically sorts elements and removes duplicates
        Set<Integer> tree = new TreeSet<>();

                                                                                    // Insert elements into the TreeSet (acts like a BST)
        for (int num : arr) {
            tree.add(num);
        }

                                                                                    // Print sorted elements
        System.out.println("Sorted elements:"+ tree);

        for( int num: tree){
            System.out.print(num);
       }

    }
}
