public class CompareToMethod
{
    public static void main(String[] args)
    {
      String str1 = "ShriRam";
      String str2 = "Shiv";
      String str3 = "Vishnu";
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str2.compareTo(str3));
        System.out.println(str2.compareTo(str1));
        System.out.println(str3.compareTo(str1));
        System.out.println(str3.compareTo(str2));
    }
}
