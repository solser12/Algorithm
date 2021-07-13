package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11657_타임머신 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        dist[1] = 0;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                int from = edges[j][0];
                int to = edges[j][1];
                int cost = edges[j][2];
                if (dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                    if (i == N) {
                        System.out.println("-1");
                        System.exit(0);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(dist[i] != Long.MAX_VALUE ? dist[i] : -1).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
