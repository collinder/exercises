import java.util.stream.*; 
public class FindOutlier {
  static int find(int[] integers) {
    int even = 0;
    if (integers[0] % 2 == 0)
      even++;
    if (integers[1] % 2 == 0)
      even++;
    if (integers[2] % 2 == 0)
      even++;
    if (even > 1)
      return IntStream.of(integers).filter((x) -> !isEven(x)).findFirst().orElse(0);
    else
      return IntStream.of(integers).filter((x) -> isEven(x)).findFirst().orElse(0);
  }
  static boolean isEven(int number) {
    if (number % 2 == 0)
      return true;
    else
      return false;
  }
}
