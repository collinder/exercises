import java.util.stream.*; 
import java.util.*; 
import java.util.regex.*;


public class A {
  public static int findEvenIndex(int[] arr) {
    int guess_right = 0;
    while (true) {
      int left = 0;
      for (int i = guess_right + 1; i < arr.length; i++) {
        left = left + arr[i];
      }
      int right = 0;
      for (int i = 0; i < guess_right; i++) {
        right = right + arr[i];
      }
      if (left == right) {
        if (guess_right == arr.length)
          return 0;
        else
          return guess_right;
      }
      guess_right++;
      if (guess_right > arr.length)
        return -1;
    }
 }

public static void main(String args[]) {
    //    System.out.println(compare("is2", "a6"));
        System.out.println(findEvenIndex(new int[] {20,10,-80,10,10,15,35}));
    }
}