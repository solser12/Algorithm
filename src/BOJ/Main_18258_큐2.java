package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_18258_큐2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashMap<String, Integer> orderToInt = init();
        MyQueue mq = new MyQueue();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int order = orderToInt.get(st.nextToken());
            if (order == 0) {
                mq.push(Integer.parseInt(st.nextToken()));
                continue;
            } else if (order == 1) {
                sb.append(mq.pop());
            } else if (order == 2) {
                sb.append(mq.size());
            } else if (order == 3) {
                sb.append(mq.empty());
            } else if (order == 4) {
                sb.append(mq.front());
            } else {
                sb.append(mq.back());
            }

            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static HashMap<String, Integer> init() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("push", 0);
        result.put("pop", 1);
        result.put("size", 2);
        result.put("empty", 3);
        result.put("front", 4);
        result.put("back", 5);

        return result;
    }

    public static class MyQueue {

        Deque<Integer> dq = new LinkedList<>();

        public void push(int num) {
            dq.offerLast(num);
        }

        public int pop() {
            return dq.isEmpty() ? -1 : dq.pollFirst();
        }

        public int size() {
            return dq.size();
        }

        public int empty() {
            return dq.isEmpty() ? 1 : 0;
        }

        public int front() {
            return dq.isEmpty() ? -1 : dq.peekFirst();
        }

        public int back() {
            return dq.isEmpty() ? -1 : dq.peekLast();
        }
    }
}
