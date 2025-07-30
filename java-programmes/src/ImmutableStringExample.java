public class ImmutableStringExample {
    public static void main(String[] args) {
        String originalString = "java";
        System.out.println(originalString);
        String modifiedString = originalString.concat(" programming");
        System.out.println(originalString);      // original string is not changed
        System.out.println(modifiedString);
        originalString.toUpperCase();
        System.out.println(originalString);
        String upperCase = originalString.toUpperCase();
        System.out.println(upperCase);
    }
}
