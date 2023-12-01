package test;
public class DecodeString {

    private  int index = 0;

    public  String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                index++;
            } else if (ch == '[') {
                index++; // Move past '['
                String nested = decodeString(s);
                for (int i = 0; i < num; i++) {
                    result.append(nested);
                }
                num = 0;
            } else if (ch == ']') {
                index++; // Move past ']'
                return result.toString();
            } else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        
    	DecodeString a = new DecodeString();
    	DecodeString b = new DecodeString();
    	DecodeString c = new DecodeString();
    	System.out.println(a.decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(b.decodeString("3[a2[c]]")); // Output: "accaccacc"
        System.out.println(c.decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }
}