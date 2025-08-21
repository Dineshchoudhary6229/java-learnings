// Here single task with single thread

public class Mthreading_Runnable implements  Runnable
{
  public void run()

  {
      System.out.println("Thread through Runnnable implements ");
  }

    public static void main(String[] args)
    {
      Mthreading_Runnable mt1 = new Mthreading_Runnable();
      Thread th = new Thread(mt1);                             // as runnable class dont have start method so
      th.start();                                              // we create thread class object here and pass
                                                //object mt1 as an argument to it .
    }
}


