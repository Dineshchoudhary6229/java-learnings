// create thread and set its name

public class ThreadName1 extends Thread
{
    public void run()
    {
        String str1 = "Hello";
        System.out.println(Thread.currentThread().getName());   // gives output as thread-0
        Thread.currentThread().setName("Dinesh");               // set name of thread as "Dinesh"
        System.out.println(Thread.currentThread().getName());   // gives output as thread name "Dinesh"
    }

    public static void main(String[] args)
    {
      ThreadName1 t = new ThreadName1();                       //create  object for ThreadName class
      t.start();                                               // start a new thread
        t.setName("Java");                                     // set the name of thread as Java

        System.out.println(Thread.currentThread().getName());   //  gives output "main" as thread

        ThreadName1 th = new ThreadName1();                      // create th object for ThreadName class
        th.start();                                              // start a new thread
        th.setName("Python");                                  // set the name of thread as Python
    }
}
