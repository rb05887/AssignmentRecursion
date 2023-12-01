package test;

public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        k--; 

        int[] factorial = new int[n];
        factorial[0] = 1;

        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        generatePermutation(result, numbers, factorial, k, n);
        return result.toString();
    }

    private static void generatePermutation(StringBuilder result, int[] numbers, int[] factorial, int k, int n) {
        if (n == 0) {
            return;
        }

        int index = k / factorial[n - 1];
        result.append(numbers[index]);
        for (int i = index; i < n - 1; i++) {
            numbers[i] = numbers[i + 1];
        }

        k %= factorial[n - 1];
        generatePermutation(result, numbers, factorial, k, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3)); 
        System.out.println(getPermutation(9, 9)); 
        System.out.println(getPermutation(3, 1)); 
    }
}