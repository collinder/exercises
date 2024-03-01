public class NumberUtils {
public static boolean isNarcissistic(int number) {
        int[] digits = Integer.toString(number).chars().map(c -> c-'0').toArray();
        int po = digits.length;
        long clr = 0;
        for (int d : digits) {
            clr = clr + Math.round(Math.pow(d, po));
        }
        if (clr == number)
            return true;
        else
            return false;
    }
}
