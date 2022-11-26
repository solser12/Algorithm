package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소_스패닝_트리 {

    static int V, E, cnt = 0, ans = 0;
    static ArrayList<Edge>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V];
        for (int i = 0; i < V; i++) list[i] = new ArrayList<>();
        visit = new boolean[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, dist));
            list[end].add(new Edge(start, dist));
        }

        prim();

        System.out.println(ans);
        br.close();
    }

    static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visit[e.x]) continue;
            visit[e.x] = true;
            ans += e.dist;
            cnt++;
            if (cnt == V) return;
            for (int i = 0; i < list[e.x].size(); i++) {
                if (visit[list[e.x].get(i).x]) continue;
                pq.add(list[e.x].get(i));
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int x, dist;

        public Edge(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
