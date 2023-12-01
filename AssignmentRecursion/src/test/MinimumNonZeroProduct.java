package test;
public class MinimumNonZeroProduct {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        
        System.out.println(minNonZeroProduct(1)); 
        System.out.println(minNonZeroProduct(2)); 
        System.out.println(minNonZeroProduct(3)); 
    }

    public static long minNonZeroProduct(int p) {
        long maxVal = (1L << (2 * p)) - 1;
        long power = (1L << p) - 2;

        return (powerMod(maxVal - 1, power) * maxVal) % MOD;
    }

    private static long powerMod(long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long halfPower = powerMod(base, exp / 2) % MOD;
        long result = (halfPower * halfPower) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }
}