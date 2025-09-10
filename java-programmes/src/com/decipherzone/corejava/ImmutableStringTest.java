public class ImmutableStringTest {
    public static void main(String[] args) {
        String s = "Hello";
        s.concat("World");
        System.out.println(s);                 // immutable so string doesn't concatenate
        String str =s.concat("Friend");    // new object store the concatenated result so concatenate
        System.out.println(str);               // but origin string s doesn't change
    }
}
