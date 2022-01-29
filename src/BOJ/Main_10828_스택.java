package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828_스택 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (cmd.equals("pop")) {
                sb.append(stack.pop()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(stack.empty()).append('\n');
            } else {
                sb.append(stack.top()).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        int[] arr;
        int index;

        public Stack(int size) {
            this.arr = new int[size];
            this.index = 0;
        }

        public void push(int num) {
            arr[index] = num;
            index++;
        }

        public int pop() {
            if (index == 0) return -1;
            return arr[--index];
        }

        public int size() {
            return index;
        }

        public int empty() {
            if (index == 0) return 1;
            return 0;
        }

        public int top() {
            if (index == 0) return -1;
            return arr[index - 1];
        }
    }
}
