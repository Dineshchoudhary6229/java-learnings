public class StringCompareOperator
{
    public static void main(String[] args)
    {
        String str1 = "Ram";                        // string obj reference is in string literal constant pool
        String str2 = "Ram";
        String str3 = new String("Ram");   // string value is same but this string is created using
        System.out.println("Comparing two strings having same ref in string constnat pool :\n"+ (str1==str2) );         // new keyword so its obj reference in heap
        System.out.println( str1==str3);
        System.out.println(str2==str3);
    }
}
