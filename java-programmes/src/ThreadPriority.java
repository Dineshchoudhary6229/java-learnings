public class ThreadPriority extends Thread
{
    public void run()
    {
        System.out.println("Child Thread");
        Thread.currentThread().setName("Java-1");
        Thread.currentThread().setPriority(6);                           // we can set child priority here also .


        System.out.println("child priority: " + Thread.currentThread().getPriority());
        System.out.println("Name of child thread :" + Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        System.out.println("Name of Main thread: "+ Thread.currentThread().getName());
        System.out.println("This is main Thread");
        System.out.println("Priority of main thread : " + Thread.currentThread().getPriority());
        ThreadPriority tp1 = new ThreadPriority();
        tp1.setPriority(3);                                         // prority of child thread can be set from here also

        tp1.start();
        ThreadPriority tp2 = new ThreadPriority();
        tp2.start();
    }
}
