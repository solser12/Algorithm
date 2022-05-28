package Programmers;

import java.util.Stack;

public class _3진법뒤집기 {

    public int solution(int n) {

        Stack<Integer> ternary = new Stack<>();
        while (n >= 3) {
            ternary.push(n % 3);
            n /= 3;
        }
        ternary.push(n);

        int ans = 0, num = 1;
        while (!ternary.isEmpty()) {
            ans += ternary.pop() * num;
            num *= 3;
        }

        return ans;
    }
}
