public class ThreadName
{
    public static void main(String[] args)
    {
       String str1 = "Hello";
        System.out.println(Thread.currentThread().getName());  // used to get the current thread name
        Thread.currentThread().setName("New Thread1");         // it set the name of thread whatever we want to set
        System.out.println(Thread.currentThread().getName());
    }
}
