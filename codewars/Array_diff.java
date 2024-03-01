import java.util.stream.*; 
import java.util.*; 


public class Kata {
public static int[] arrayDiff(int[] a, int[] b) {
    HashSet<Integer> setty = new HashSet<>();
    for (int e : b) {
        setty.add(e);
    }
    return Arrays.stream(a).filter(x -> !setty.contains(x)).toArray();
}
}
