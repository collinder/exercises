public class Solution {
public static int arith_prog_sum_from_zero(int target, int step)
{
    int count = target / step;
    int last = step * count;
    int sum = last * (count + 1) / 2;

    return sum;
}
public int solution(int number) {
  
  if (number < 0) {
      return -1;
    }
  
    int target = number - 1;
    int suma = arith_prog_sum_from_zero(target, 3) + arith_prog_sum_from_zero(target, 5) - arith_prog_sum_from_zero(target, 15);
    return suma;
  
  }
}
