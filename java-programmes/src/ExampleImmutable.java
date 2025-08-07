public class ExampleImmutable
{
    public static void main(String[] args)
    {
        String str1 = "Hello";
        System.out.println("Original string: " + str1);
        str1 = str1 + " World";

        System.out.println("Modified string: " + str1);
    }
}