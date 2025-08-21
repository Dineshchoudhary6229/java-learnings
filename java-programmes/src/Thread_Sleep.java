// sleep method in thread

public class Thread_Sleep extends Thread
{
    public void run()
    {
        System.out.println("This is user created thread with sleep method : " + currentThread().getName() );
             // return the name of thread

        try {
            for (int i = 0; i <= 5; i++)
            {
                sleep(1000);           // sleep method and it's a static method
                System.out.println(i);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("This is main Thread : " + currentThread().getName());

        for(int i =0; i<=5; i++)
        {
            System.out.println(i);
        }
        Thread_Sleep ts = new Thread_Sleep();
        ts.setName("SleepThread");                // set name of thread as SleepThread
        ts.start();                              // start the SleepThread

    }
}
