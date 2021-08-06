package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18769_그리드네트워크 {

    static int R, C, ans, cnt;
    static Node[][] nodes;
    static boolean[][] visited;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            cnt = R * C;
            nodes = new Node[R][C];
            visited = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    nodes[i][j] = new Node(i, j);
                }
            }

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C - 1; j++) {
                    int cost = Integer.parseInt(st.nextToken());
                    nodes[i][j].way[3] = cost;
                    nodes[i][j+1].way[2] = cost;
                }
            }

            for (int i = 0; i < R - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    int cost = Integer.parseInt(st.nextToken());
                    nodes[i][j].way[1] = cost;
                    nodes[i+1][j].way[0] = cost;
                }
            }

            prim();
        }

        System.out.println(sb);
        br.close();
    }

    public static void prim() {

        PriorityQueue<Next> pq = new PriorityQueue<>();
        pq.add(new Next(nodes[0][0].x + dt[1][0], nodes[0][0].y + dt[1][1], 1, nodes[0][0].way[1]));
        pq.add(new Next(nodes[0][0].x + dt[3][0], nodes[0][0].y + dt[3][1], 3, nodes[0][0].way[3]));
        visited[0][0] = true;
        cnt--;

        while (cnt > 0) {

            Next next = pq.poll();
            if (visited[next.x][next.y]) continue;

            ans += next.cost;
            visited[next.x][next.y] = true;
            cnt--;


            for (int d = 0; d < 4; d++) {
                // 변두리면 continue
                if (nodes[next.x][next.y].way[d] == 0) continue;

                int dx = next.x + dt[d][0];
                int dy = next.y + dt[d][1];

                // 이미 방문처리
                if (visited[dx][dy]) continue;

                pq.add(new Next(dx, dy, d, nodes[next.x][next.y].way[d]));
            }
        }

        sb.append(ans).append('\n');
    }

    public static class Next implements Comparable<Next> {
        int x, y, way, cost;

        public Next(int x, int y, int way, int cost) {
            this.x = x;
            this.y = y;
            this.way = way;
            this.cost = cost;
        }

        @Override
        public int compareTo(Next o) {
            return this.cost - o.cost;
        }
    }

    public static class Node {
        int x, y;
        int[] way = new int[4];

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.way[0] = 0;
            this.way[1] = 0;
            this.way[2] = 0;
            this.way[3] = 0;
        }
    }
}
