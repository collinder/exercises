public class DRoot {
  public static int digital_root(int n) {
    if (n < 10)
        return n;
    else {
        int sum = 0;
        for (int i = n; i > 0; i = i/10) {
        sum = sum + i%10;
        }
        return digital_root(sum);
    }
}
}
