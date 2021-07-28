package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {

    static int n;
    static float[][] stars, length;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stars = new float[n][2];
        length = new float[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());
            stars[i][0] = x;
            stars[i][1] = y;

            for (int j = 0; j < i; j++) {
                float result = (float) Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                length[i][j] = result;
                length[j][i] = result;
            }
        }

        prim();

        br.close();
    }

    public static void prim() {

        int cnt = 0;
        float ans = 0.0f;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        while (cnt != n) {
            Edge edge = pq.poll();

            if (visited[edge.star]) continue;

            visited[edge.star] = true;
            cnt++;
            ans += edge.len;

            for (int i = 0; i < n; i++) {
                if (i == edge.star) continue;
                float f = length[edge.star][i];
                if (!visited[i]) {
                    pq.add(new Edge(i, f));
                }
            }
        }

        System.out.printf("%.2f%n", ans);
    }

    public static class Edge implements Comparable<Edge> {
        int star;
        float len;

        public Edge(int star, float len) {
            this.star = star;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return Float.compare(this.len, o.len);
        }
    }
}
