import java.util.*;

interface collection
{
    boolean add(Object obj);
    boolean addAll(Collection c);

    boolean remove(Object obj);
    boolean removeAll(Collections c);

    void clear();

    boolean  contains(Objects obj);
    boolean containsAll(Collection c);

    boolean isEmpty();

    int size();

    Iterator iterator();

}
interface List extends Collection
{
    // overrides collection interface methods

    void add(int index , Objects obj);
    void addAll(int index, collection c);
   Objects get(int index);
   Objects remove(int index);
   Objects set(int index, Objects newobj);     // replace the existing object from the provided index
    int indexOf(Objects obj);                  // return index of the provided object
    int lastIndexOf(Objects obj);


}
//public class LinkedList implements List, Deque
//{
//    // overrides methods of collections , list, deque
//
//    void addFirst(Objects obj){};
//    void addLast(Objects obj){};
//
//    Objects getFirst() {
//        return null;
//    }
//
//    public Objects getLast(){
//        return null;
//    };


//}
