package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10845_큐 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue q = new Queue();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.push(num);
            } else if (cmd.equals("pop")) {
                sb.append(q.pop()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(q.empty()).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(q.front()).append('\n');
            } else {
                sb.append(q.back()).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Queue {
        Node front, back;
        int size = 0;

        public void push(int num) {
            if (size == 0) {
                front = new Node(num);
                back = front;
            } else {
                back.next = new Node(num);
                back = back.next;
            }
            size++;
        }

        public int pop() {
            if (size == 0) return -1;
            int result = front.value;
            front = front.next;
            size--;
            return result;
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (size == 0) return 1;
            return 0;
        }

        public int front() {
            if (size == 0) return -1;
            return front.value;
        }

        public int back() {
            if (size == 0) return -1;
            return back.value;
        }
    }

    public static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
