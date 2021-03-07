package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            double ans = 0;
            int N = Integer.parseInt(br.readLine());
            int[][] islands = new int[N][2];
            boolean[] visit = new boolean[N];
            double[][] list = new double[N][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    islands[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    double x = Math.pow(islands[i][0] - islands[j][0], 2);
                    double y = Math.pow(islands[i][1] - islands[j][1], 2);
                    double len = (x + y) * E;
                    list[i][j] = len;
                    list[j][i] = len;
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, 0));
            for (int i = 1; i < list[0].length; i++) {
                pq.add(new Edge(i, list[0][i]));
            }
            visit[0] = true;
            int cnt = 1;

            while(true) {
                Edge e = pq.poll();

                if(visit[e.x]) continue;
                visit[e.x] = true;
                ans += e.len;
                cnt++;
                if (cnt == N) break;

                for (int i = 1; i < list[e.x].length; i++) {
                    if (visit[i]) continue;
                    pq.add(new Edge(i, list[e.x][i]));
                }
            }

            sb.append('#').append(t).append(' ').append(Math.round(ans)).append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }

    static class Edge implements Comparable<Edge> {
        int x;
        double len;

        public Edge(int x, double len) {
            this.x = x;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len > o.len ? 1 : -1;
        }
    }
}
