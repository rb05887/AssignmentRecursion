package test;

	public class CountGoodNumbers {
	    private static final int MOD = 1_000_000_007;

	    public static void main(String[] args) {
	        System.out.println(countGoodNumbers(1)); 
	        System.out.println(countGoodNumbers(4)); 
	        System.out.println(countGoodNumbers(50)); 
	    }

	    public static int countGoodNumbers(int n) {
	        return (int) (countGoodNumbersHelper(n, true) % MOD);
	    }

	    private static long countGoodNumbersHelper(int n, boolean isEvenPosition) {
	        if (n == 0) {
	            return 1;
	        }

	        long count = 0;
	        int startDigit = isEvenPosition ? 0 : 1;

	        for (int digit = startDigit; digit <= 9; digit += 2) {
	            if ((isEvenPosition && digit % 2 == 0) || (!isEvenPosition && isPrime(digit))) {
	                count = (count + countGoodNumbersHelper(n - 1, !isEvenPosition)) % MOD;
	            }
	        }

	        return count;
	    }

	    private static boolean isPrime(int num) {
	        if (num < 2) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

