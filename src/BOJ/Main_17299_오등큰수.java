package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17299_오등큰수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[1000001];
        int[] list = new int[N];
        Stack stack = new Stack(N);
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            count[num]++;
            list[i] = num;
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && count[stack.peek().num] < count[list[i]]) {
                Node node = stack.pop();
                ans[node.idx] = list[i];
            }

            stack.push(new Node(list[i], i));
        }

        while (!stack.isEmpty()) {
            ans[stack.pop().idx] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        Node[] stack;
        int idx = 0;

        public Stack(int N) {
            stack = new Node[N + 1];
        }

        public void push(Node node) {
            stack[idx++] = node;
        }

        public boolean isEmpty() {
            return idx == 0;
        }

        public Node pop() {
            return stack[--idx];
        }

        public Node peek() {
            return stack[idx-1];
        }

        public int size() {
            return idx;
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
