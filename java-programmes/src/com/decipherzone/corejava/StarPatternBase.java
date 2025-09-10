import java.util.ArrayList;                        // base programme for star pattern programme using arraylist.
public class StarPatternBase
{

        public static void main(String[] args)
        {
            int n = 5;
            char symbol = 'A';
            ArrayList<String> pattern = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 1; j <= i; j++) {
                    row.append(symbol).append(" ");
                }
                pattern.add(row.toString().trim());
            }

            for (String row : pattern) System.out.println(row);
        }
    }


