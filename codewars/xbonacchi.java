import java.util.stream.*; 
import java.util.*; 
import java.util.regex.*;


public class A {
  public static double[] xbonacci(double[] signature, int n) {
    int sig_l = signature.length;
    if ((n < 1) || (sig_l < 1))
      return new double[0];
    if (n < sig_l)
      return signature;
    double[] result = Arrays.copyOf(signature, n);;
    for (int i = signature.length; i < result.length; i++) {
      result[i] = 0;
      for (int j = i-sig_l; j < i; j++) {
        result[i] = result[i] + result[j];
      }
      }
      return result;
  }

public static void main(String args[]) {
        System.out.println(Arrays.toString(A.xbonacci(new double []{1,1,1},10)));

        System.out.println(Arrays.toString(A.xbonacci(new double []{1},10)));
        System.out.println(Arrays.toString(A.xbonacci(new double []{0,1},10)));
        System.out.println(Arrays.toString(A.xbonacci(new double []{1,0,0,0,0,0,1},10)));
    //    System.out.println(compare("is2", "a6"));
    }
}

