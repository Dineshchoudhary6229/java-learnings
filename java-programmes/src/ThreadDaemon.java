// programme for Daemon Thread

public class ThreadDaemon extends Thread
{
    public void run()
    {
        if(Thread.currentThread().isDaemon())
        {
            System.out.println("Daemon Thread");
        }
        else
        {
            System.out.println("Child Thread");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Main Thread");
      ThreadDaemon t = new ThreadDaemon();
      t.setDaemon(true);                            //setting daemon thread and this should always before t.start()
      t.start();

    }
}
