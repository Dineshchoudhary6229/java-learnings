public class StringBufferExample
{
    public static void main(String[] args)
    {
      StringBuffer sb = new StringBuffer("Hello");
      sb.insert(5," World , How are you!");
      System.out.println(sb);
      sb.delete(3,6);
      sb.append("do good let's wait for result to be good ");
        System.out.println(sb);
    }
}
