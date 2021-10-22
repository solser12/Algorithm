package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1662_압축 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack stack = new Stack();

        String input = br.readLine();
        int length = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                if (length - 1 > 0) {
                    stack.push(length - 1);
                }
                stack.push(input.charAt(i - 1) - '0');
                stack.push(-1);
                length = 0;
            } else if (c == ')') {
                int sum = length;
                while (stack.peek() != -1) {
                    sum += stack.pop();
                }
                stack.pop();
                int num = stack.pop() * sum;
                stack.push(num);
                length = 0;
            } else {
                length++;
            }
        }

        int ans = length;

        for (int i = 0; i < stack.index; i++) {
            ans += stack.arr[i];
        }

        System.out.println(ans);
        br.close();
    }

    public static class Stack {
        int[] arr = new int[50];
        int index = 0;

        public void push(int n) {
            arr[index++] = n;
        }

        public int pop() {
            return arr[--index];
        }

        public int peek() {
            return arr[index-1];
        }
    }
}
