package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789_도키도키간식드리미 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int now = 1;
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
            while (!stack.isEmpty()) {
                if (stack.peek() != now) {
                    break;
                }
                now++;
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
        br.close();
    }
}
