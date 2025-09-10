// immutable class --> must have constructor, class name shoud be final,use only getter not setter.

public final class Person
{
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Only getters, no setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
