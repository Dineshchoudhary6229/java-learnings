// single task with multiple thread
public class MThread_1Task extends Thread
{
    public void run()
    {
        System.out.println("Single task with multiple thread");
    }

    public static void main(String[] args)               // by default thread by JVM
    {
      MThread_1Task mt1 = new MThread_1Task();           // Thread 2
      mt1.start();
      MThread_1Task mt2 = new MThread_1Task();           // Thread 3
      mt2.start();
      MThread_1Task mt3 = new MThread_1Task();            //Thread 4
      mt3.start();
    }
}
