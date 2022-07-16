package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866_덱 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashMap<String, Integer> orderToInt = init();

        MyDeque mdq = new MyDeque();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int order = orderToInt.get(st.nextToken());
            if (order == 0) {
                mdq.pushFront(Integer.parseInt(st.nextToken()));
                continue;
            } else if (order == 1) {
                mdq.pushBack(Integer.parseInt(st.nextToken()));
                continue;
            } else if (order == 2) {
                sb.append(mdq.popFront());
            } else if (order == 3) {
                sb.append(mdq.popBack());
            } else if (order == 4) {
                sb.append(mdq.size());
            } else if (order == 5) {
                sb.append(mdq.empty());
            } else if (order == 6) {
                sb.append(mdq.front());
            } else {
                sb.append(mdq.back());
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static HashMap<String, Integer> init() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("push_front", 0);
        result.put("push_back", 1);
        result.put("pop_front", 2);
        result.put("pop_back", 3);
        result.put("size", 4);
        result.put("empty", 5);
        result.put("front", 6);
        result.put("back", 7);
        return result;
    }

    public static class MyDeque {

        Deque<Integer> dq = new LinkedList<>();

        public void pushFront(int num) {
            dq.offerFirst(num);
        }

        public void pushBack(int num) {
            dq.offerLast(num);
        }

        public int popFront() {
            return isEmpty() ? -1 : dq.pollFirst();
        }

        public int popBack() {
            return isEmpty() ? -1 : dq.pollLast();
        }

        public int size() {
            return dq.size();
        }

        public int empty() {
            return isEmpty() ? 1 : 0;
        }

        public int front() {
            return isEmpty() ? -1 : dq.peekFirst();
        }

        public int back() {
            return isEmpty() ? -1 : dq.peekLast();
        }

        private boolean isEmpty() {
            return dq.size() == 0;
        }
    }
}
