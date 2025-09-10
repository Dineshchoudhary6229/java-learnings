// String Reverse through StringBuilder/StringBuffer

public class StringReverse
{
  public static String reverseString(String str)
  {
      StringBuilder sb = new StringBuilder(str);
      sb.reverse();
      return    sb.toString();
  }

    public static void main(String[] args)
    {
        System.out.println("String reverse through StringBuilder:\n");
      String a = StringReverse.reverseString("Where are you going ");
      String b = StringReverse.reverseString("I am learning Java");
        System.out.println(a);
        System.out.println(b);
        System.out.println(StringReverse.reverseString("Where are you going "));  // we can use this also to print the same
    }
}
