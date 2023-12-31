package test;

public class MonkeyCollision {

		  public static int  monkeyMove(int n) {
		    final int res = (int) modPow(2, n) - 2;
		    return res < 0 ? res + kMod : res;
		  }

		  private static final int kMod = 1_000_000_007;

		  private static long modPow(long x, int n) {
		    if (n == 0)
		      return 1;
		    if (n % 2 == 1)
		      return x * modPow(x, n - 1) % kMod;
		    return modPow(x * x % kMod, n / 2);
		  }
		  
		  public static void main(String[] args) {
		        int n1 = 3;
		        System.out.println(monkeyMove(n1)); 

		        int n2 = 4;
		        System.out.println(monkeyMove(n2)); 
		    }
}