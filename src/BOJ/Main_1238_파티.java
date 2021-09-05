package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {

    static int N, M, X, idx = 0;
    static ArrayList<Node>[] goParty, goHome;
    static int[][] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        goParty = new ArrayList[N];
        goHome = new ArrayList[N];
        dist = new int[2][N];
        for (int i = 0; i < N; i++) {
            goParty[i] = new ArrayList<>();
            goHome[i] = new ArrayList<>();
        }
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            goParty[start].add(new Node(end, dist));
            goHome[end].add(new Node(start, dist));
        }

        dijkstra(goParty);
        idx++;
        dijkstra(goHome);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(dist[0][i] + dist[1][i], ans);
        }

        System.out.println(ans);
        br.close();
    }

    public static void dijkstra(ArrayList<Node>[] way) {

        boolean[] vistied = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        dist[idx][X] = 0;

        while (!pq.isEmpty()) {
            int now = pq.poll().end;

            if (vistied[now]) continue;
            vistied[now] = true;

            for (Node n : way[now]) {
                if (dist[idx][n.end] > dist[idx][now] + n.dist) {
                    dist[idx][n.end] = dist[idx][now] + n.dist;
                    pq.add(new Node(n.end, dist[idx][n.end]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int end, dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
