package Programmers;

import java.util.Stack;

public class _124나라의숫자 {

    public  String solution(int n) {

        Stack<Integer> stack = new Stack<>();

        while (n >= 4) {
            n += (n - 1) / 3;
            stack.push(change(n % 4));
            n /= 4;
        }
        stack.push(change(n));

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public int change(int num) {
        return num == 3 ? 4 : num;
    }
}
