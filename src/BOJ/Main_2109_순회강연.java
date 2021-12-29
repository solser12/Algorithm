package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2109_순회강연 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[10001];
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(d, p));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            for (int i = lecture.deadLine; i >= 1; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    ans += lecture.price;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Lecture implements Comparable<Lecture> {
        int deadLine, price;

        public Lecture(int deadLine, int price) {
            this.deadLine = deadLine;
            this.price = price;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.price - this.price;
        }
    }
}
