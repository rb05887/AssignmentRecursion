package test;
import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String expression1 = "2-1-1";
        String expression2 = "2*3-4*5";

        System.out.println("Expression: " + expression1);
        System.out.println("Results: " + diffWaysToCompute(expression1));

        System.out.println("\nExpression: " + expression2);
        System.out.println("Results: " + diffWaysToCompute(expression2));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        return result;
    }
}