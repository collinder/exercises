class Persist {
public static long multiply(long n) {
    long res = 1;
    for (long i = n; i != 0; i = i / 10) {
        res = res * (i % 10);
    }
    return res;
}
public static int persistence(long n) {
        int persist = 0;
        while (n > 9) {
            n = multiply(n);
            persist++;
        }
		return persist; 
	}
}
