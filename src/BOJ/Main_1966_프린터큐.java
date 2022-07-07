package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1966_프린터큐 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            PrinterQueue pq = new PrinterQueue();

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pq.add(new Request(i, Integer.parseInt(st.nextToken())));
            }

            for (int i = 1; i <= n; i++) {
                if (pq.poll().num == m) {
                    sb.append(i).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class PrinterQueue {

        Queue<Request> q = new LinkedList<>();
        PriorityQueue<Integer> weight = new PriorityQueue<>(Collections.reverseOrder());

        public void add(Request r) {
            q.offer(r);
            weight.offer(r.weight);
        }

        public Request poll() {

            while (q.peek().weight != weight.peek()) {
                q.offer(q.poll());
            }

            weight.poll();
            return q.poll();
        }
    }

    public static class Request {

        int num, weight;

        public Request(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
