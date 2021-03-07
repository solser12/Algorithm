package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753_최단경로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Edge>[] list = new ArrayList[V+1];
        int[] distance = new int[V+1];
        boolean[] visit = new boolean[V+1];

        for (int i = 1; i < V+1; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, dist));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        distance[K] = 0;
        pq.add(new Edge(K, 0));

        while(!pq.isEmpty()) {
            int now = pq.poll().node;

            if (visit[now]) continue;;
            visit[now] = true;

            for (Edge e : list[now]) {
                if (distance[e.node] > distance[now] + e.dist) {
                    distance[e.node] = distance[now] + e.dist;
                    pq.add(new Edge(e.node, distance[e.node]));
                }
            }
        }

        for (int i = 1; i < V+1; i++) {
            sb.append(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF").append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }

    static class Edge implements Comparable<Edge>{
        int node, dist;

        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
