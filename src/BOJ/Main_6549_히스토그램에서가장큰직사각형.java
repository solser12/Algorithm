package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_6549_히스토그램에서가장큰직사각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            long ans = 0;
            Stack stack = new Stack(n);
            for (int i = 0; i <= n; i++) {
                int num = i != n ? Integer.parseInt(st.nextToken()) : 0;
                if (stack.isEmpty()) {
                    stack.push(new Node(num, i));
                    continue;
                }

                if (stack.peek().num < num) {
                    stack.push(new Node(num, i));
                } else {
                    while (true) {
                        Node node = stack.pop();
                        long calc = stack.isEmpty() ? (long) node.num * i : (long) (i - stack.peek().idx - 1) * node.num;
                        ans = Math.max(ans, calc);

                        if (stack.isEmpty() || stack.peek().num < num) {
                            stack.push(new Node(num, i));
                            break;
                        }
                    }
                }
            }

            bw.write(ans + "\n");
        }

        bw.close();
        br.close();
    }

    public static class Stack {
        Node[] stack;
        int idx;

        public Stack(int n) {
            stack = new Node[n + 1];
            idx = 0;
        }

        public void push(Node node) {
            stack[idx++] = node;
        }

        public Node pop() {
            return stack[--idx];
        }

        public Node peek() {
            return stack[idx-1];
        }

        public boolean isEmpty() {
            return idx == 0;
        }
    }

    public static class Node {
        int num, idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
