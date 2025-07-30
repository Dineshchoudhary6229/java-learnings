import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sun
{
public static void main(String[] args) throws IOException
{
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
    
    System.out.println("Enter your Name:");
    String str1 = br.readLine();
    System.out.println("Name"+ str1);
    System.out.println("Enter Your Age:");
    String str2 = br.readLine();
    System.out.println("Age"+str2);

}
    }

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class Sun {
//     public static void main(String[] args) throws IOException {
//         InputStreamReader ir = new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ir);

//         System.out.print("Enter your Name: ");
//         String str1 = br.readLine();

//         System.out.print("Enter your Age: ");
//         String str2 = br.readLine();

//         System.out.println("Name: " + str1);
//         System.out.println("Age: " + str2);
//     }
// }
