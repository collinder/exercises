public class BitCounting {
	public static int countBits(int n){
        int sum = 0;
        for (int i = n; i != 0; i = i / 2)
        {
            sum = sum + (i%2);
        }
        return sum;
	}
}
