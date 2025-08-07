public class Mthreading extends Thread
{
 public void run()
 {
     System.out.println("through thread class extends");
 }

    public static void main(String[] args)
    {
      Mthreading mt = new Mthreading();
      mt.start();
    }
}
