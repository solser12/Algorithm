package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_3124_최소스패닝트리_Prim {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Edge>[] list = new List[V+1];
            for (int i = 1; i < V+1; i++) {
                list[i] = new ArrayList<>();
            }
            int[] minDist = new int[V+1];
            Arrays.fill(minDist, Integer.MAX_VALUE);
            boolean[] visit = new boolean[V+1];
            long ans = 0;

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                list[start].add(new Edge(end, dist));
                list[end].add(new Edge(start, dist));
            }

            int cnt = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(1, 0));

            while(!pq.isEmpty()) {
                Edge e = pq.poll();
                if (visit[e.end]) continue;
                cnt++;
                ans += e.dist;
                visit[e.end] = true;
                for (Edge temp : list[e.end]) {
                    pq.add(temp);
                }
                if (cnt == E) break;
            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static class Edge implements Comparable<Edge>{
        int end, dist;

        public Edge(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}
