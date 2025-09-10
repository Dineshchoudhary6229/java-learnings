abstract class Animal
{
 abstract void makesound();
 void eat()
   {
     System.out.println("This animal is eating");
    }
}
class Dog extends Animal
  {
   void makesound()
   {
    System.out.println("Bark");
   }
}
class Zoo
{
 public static void main(String args[])
 {
  Dog obj1=new Dog();
  obj1.makesound();
  obj1.eat();
}
}