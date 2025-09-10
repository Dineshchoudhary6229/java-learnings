public class StringComparisionEqual_Method
{
    public static void main(String[] args)
    {
      String str1 = "Ram";
      String str2 = "Ram";
      String str3 = "rAm";
      boolean equalObj = str1.equals(str2);
           System.out.println(equalObj);
           System.out.println(str1.equals(str3));
      String str4 = new String("Ram");   // String with new keyword having stored in heap memory not in String constant pool
           System.out.println(str1.equals(str4));
      String str5 = "Ravan";
      String str6 = "raVan";
      boolean str7 = str5.equalsIgnoreCase(str6);  // equalsIgnoreCase method ignore case-sensitive of strings
        System.out.println(str7);
        System.out.println(str5.equals(str6));

    }
}
