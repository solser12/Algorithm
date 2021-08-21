package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1725_히스토그램 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);

        for (int i = 0; i <= N; i++) {
            int num = i != N ? Integer.parseInt(br.readLine()) : 0;
            if (stack.isEmpty()) {
                stack.push(new Node(num, i));
                continue;
            }

            if (stack.peek().num < num) {
                stack.push(new Node(num, i));
            } else {
                while (true) {
                    Node node = stack.pop();
                    int calc = stack.isEmpty() ? node.num * i : (i - stack.peek().idx - 1) * node.num;
                    ans = Math.max(ans, calc);

                    if (stack.isEmpty() || stack.peek().num < num) {
                        stack.push(new Node(num, i));
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
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
