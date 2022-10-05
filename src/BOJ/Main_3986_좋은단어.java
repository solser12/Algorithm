package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986_좋은단어 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : word) {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}