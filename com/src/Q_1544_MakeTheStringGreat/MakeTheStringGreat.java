package Q_1544_MakeTheStringGreat;

import java.util.Stack;

public class MakeTheStringGreat {

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(approach2(s));
    }

    public static String approach1(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(Math.abs(s.charAt(i) - s.charAt(i+1)) == 32) {
                return approach1(s.substring(0,i) + s.substring(i+2));
            }
        }
        return s;
    }

    public static String approach2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
