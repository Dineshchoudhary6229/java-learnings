class Person
{
    private String name;
    private int age;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        if(age>0)
        {
            this.age=age;
        }
        else
        {
            System.out.println("Negative age is not allowed");
        }
    }
}
public class Person1
{
    public static void main(String args[])
    {
        Person p = new Person();
        p.setName("Anil");
        p.setAge(30);
        System.out.println("Name is :"+p.getName());
        System.out.println("Age is :"+ p.getAge());
    }

}