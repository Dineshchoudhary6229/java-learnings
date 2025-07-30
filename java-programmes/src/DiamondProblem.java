interface A
{
    void display();
}
interface  B
{
    void display();
}
class C implements A,B
{
    public void display()
    {
        System.out.println("This is class C");
    }
}
class D 
{
    public static void main(String args[])
    {
        C obj = new C();
        obj.display();
    }
}