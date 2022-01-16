package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1874_스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int index = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack stack = new Stack(N);
        for (int i = 1; i <= N; i++) {
            stack.push(i);
            sb.append('+').append('\n');
            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                index++;
                sb.append('-').append('\n');
            }
        }

        if (!stack.isEmpty()) {
            sb.setLength(0);
            sb.append("NO");
        }

        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        int[] arr;
        int index;

        public Stack(int N) {
            this.arr = new int[N];
            this.index = 0;
        }

        public void push(int num) {
            arr[index++] = num;
        }

        public int pop() {
            return arr[--index];
        }

        public int peek() {
            return arr[index - 1];
        }

        public boolean isEmpty() {
            return index == 0;
        }
    }
}
