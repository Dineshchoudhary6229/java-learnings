import java.util.ArrayList;
public class CollectionTest
{
    public static void main(String[] args)
    {
      ArrayList al = new ArrayList();
      al.add(100);                             // 100 would be treated as an object not an integer
      al.add("Dinesh");

        System.out.println(al);               // objects would be printed as collection
        System.out.println(al.add(200));      // it would print boolean value i.e true or false

        ArrayList al2 = new ArrayList();
        al2.add("aaa");
        al2.add("bbb");
        al2.add("b2c");
        System.out.println(al2);

        al.addAll(al2);
        System.out.println(al);

        System.out.println(al.contains(200));   // this mehtod is used to check in the arraylist that the
        System.out.println(al.contains(500));    // given element is in list or not so provide output as boolean.

        System.out.println(al.isEmpty());     // checks weather arraylist have elements or empty

        System.out.println(al.size());       // gives size of the arraylist
        System.out.println(al2.size());

        System.out.println(al);

        //al.remove(100);              // give an error becoz it treat 100 as index
        //System.out.println(al);

        al.remove(1);           // for remove method we have to provide index for no element
        System.out.println(al);       // in remove method for objects like name or string type we directly can
                                      // remove by providing name of the object rather than index

        al.removeAll(al2);            // remove duplicate elements from both the arraylist
        System.out.println(al);
        System.out.println(al2);

        al.clear();                    // remove all elements from the given arraylist and print an empty arraylist
        System.out.println(al);
    }
}
