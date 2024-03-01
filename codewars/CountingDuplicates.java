import java.util.stream.*; 
import java.util.*; 

public class CountingDuplicates {
   public static int duplicateCount(String text) {
       int[] sum = {0};
       HashSet<Character> encoed = new HashSet<Character>();
       HashSet<Character> counted = new HashSet<Character>();
       IntStream chars = text.chars(); 
       chars.forEach(xx -> {
           char x = Character.toLowerCase((char)xx);
           if (!counted.contains(x)) {
               if (!encoed.contains(x))
                   encoed.add(x);
               else {
                    counted.add(x);
                    sum[0] = sum[0] + 1;
              }
           }
       }
           );
       return sum[0];
  }   
}
