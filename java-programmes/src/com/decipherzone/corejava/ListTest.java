import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.ListIterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args)
    {
        List l = new ArrayList();
        l.add(10);
        l.add(50);
        l.add(60);
        l.add(null);                     // we can add any no of null values to list
        l.add(null);
        l.add(400);

        System.out.println(l);

        Iterator itr = l.iterator();           //iterator is used to retrive elements in forward dir^n only
        if(itr.hasNext()==true)           //hasNext() method returns boolean value
        {
            System.out.println(itr.next());
        }
        else
        {
            System.out.println("Check your code");
        }

        ListIterator litr =l.listIterator();   //listIterator() method to retrive elements in forward or backward both directions
                                               //ListIterator-is an interface

        while(litr.hasNext())
        {
            System.out.println(litr.next());      // next() method return object
        }
        litr.remove();                               // to remove element from the list
                                 // can'nt call remove before iterator or listiterator method if done so then it will throw an  exception


    }
}



