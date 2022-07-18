package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isBalance = true;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(') {
                    stack.push('(');
                } else if ( c == '[') {
                    stack.push('[');
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() == '[') {
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && isBalance) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
