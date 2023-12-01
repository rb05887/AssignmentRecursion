package test;
public class PowerOfFour {

    public static void main(String[] args) {
        int n1 = 16;
        int n2 = 5;
        int n3 = 1;

        System.out.println(n1 + " is a power of four: " + isPowerOfFour(n1));
        System.out.println(n2 + " is a power of four: " + isPowerOfFour(n2));
        System.out.println(n3 + " is a power of four: " + isPowerOfFour(n3));
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 4 == 0) {
            return isPowerOfFour(n / 4);
        } else {
            return false;
        }
    }
}