package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().num < num) {
                Node node = stack.pop();
                ans[node.idx] = num;
            }

            stack.push(new Node(num, i));
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans[node.idx] = -1;
        }

        for (int i : ans) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        Node[] stack;
        int idx = 0;

        public Stack(int N) {
            stack = new Node[N];
        }

        public void push(Node node) {
            stack[idx++] = node;
        }

        public Node peek() {
            return stack[idx-1];
        }

        public Node pop() {
            return stack[--idx];
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
