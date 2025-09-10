// Multiple thread with multiple tasks

class MThread_MTask extends Thread
{
 public void run()                                  // override run method of thread class
 {
     System.out.println("1st Task");
 }
}
class MThread_MTask1 extends Thread
{
    public void run()                               // override run method of thread class
    {
        System.out.println("2nd Task");
    }
}
class MThread_MTask2 extends Thread
{
    public void run()                             //override run method of thread class
    {
        System.out.println("3rd Task");
    }
}
class NewMain
{
    public static void main(String[] args)
    {
    MThread_MTask1 mt1 = new MThread_MTask1();
    mt1.start();
    MThread_MTask2 mt2 = new MThread_MTask2();
    mt2.start();
    MThread_MTask mt3 = new MThread_MTask();
    mt3.start();
    }
}