package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int money = Integer.parseInt(br.readLine());
            if (money == 0) {
                stack.pop();
            } else {
                stack.push(money);
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        System.out.println(ans);
        br.close();
    }
}
