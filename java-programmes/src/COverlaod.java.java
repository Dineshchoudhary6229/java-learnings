class A1
{
 A1()
  {
    System.out.println("this is 1st constructor");
  }
 A1(int a)
  {
    System.out.println("this is 2nd constructor");
  }
}
class COverload
{
public static void main(String args[])
{
A1 obj1=new A1();
A1 obj2=new A1(10);
}
}