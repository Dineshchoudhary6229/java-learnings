import java.util.*;

public class DupliElementArray1 
{
    public static void main(String[] args) 
{
        Set<Integer> numbers = new HashSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(5); // Duplicate, ignored
        numbers.add(8);

        System.out.println(numbers); // Output might be [2, 5, 8] in any order
    }
}
