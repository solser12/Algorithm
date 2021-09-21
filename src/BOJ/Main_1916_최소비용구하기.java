package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

    static int N, M, start, end;
    static ArrayList<Bus>[] map;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            map[start].add(new Bus(end, pay));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[end]);
        br.close();
    }

    public static void dijkstra() {

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();

            if (visited[bus.city]) continue;
            visited[bus.city] = true;


            for (Bus b : map[bus.city]) {
                if (visited[b.city] || dist[b.city] <= bus.pay + b.pay) continue;
                dist[b.city] = bus.pay + b.pay;
                pq.offer(new Bus(b.city, bus.pay + b.pay));
            }
        }
    }

    public static class Bus implements Comparable<Bus> {
        int city, pay;

        public Bus(int city, int pay) {
            this.city = city;
            this.pay = pay;
        }

        @Override
        public int compareTo(Bus o) {
            return this.pay - o.pay;
        }
    }
}
