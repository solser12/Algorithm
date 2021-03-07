package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17472_다리만들기2 {

    static int N, M, island = 0, ans = 0, count = 0;
    static int[][] map;
    static int[][] list;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = map[i][j] == 1 ? 100 : 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 100) {
                    bfs(i, j);
                    island++;
                }
            }
        }

        list = new int[island+1][island+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    bridge(i, j);
                }
            }
        }

        prim();

        System.out.println(ans == 0 ? -1 : (count != island ? -1 : ans));
        br.close();
    }

    static void prim() {
        boolean[] visit = new boolean[7];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1 ,0));

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int next = e.next;

            if (visit[next]) continue;
            visit[next] = true;
            ans += e.len;
            count++;
            if (count == island) break;

            for(int i = 1; i <= island; i++) {
                if (visit[i]) continue;
                if (list[next][i] == 0) continue;
                pq.add(new Edge(i, list[next][i]));
            }
        }
    }

    static void bridge(int x, int y) {
        int start = map[x][y];
        for (int i = 0; i < 4; i+=2) {  // 0. 아래 1. 위 2. 오른쪽 3. 왼쪽
            int dx = x, dy = y;
            int cnt = 0;
            while (true) {
                dx += di[i];
                dy += dj[i];
                if(dx < 0 || dx >= N || dy < 0 || dy >= M || map[dx][dy] == start) break;

                if (map[dx][dy] > 0) {
                    if (cnt <= 1) break;
                    int end = map[dx][dy];
                    if (list[start][end] == 0) {
                        list[start][end] = cnt;
                        list[end][start] = cnt;
                    }
                    else {
                        if (list[start][end] > cnt) {
                            list[start][end] = cnt;
                            list[end][start] = cnt;
                        }
                    }
                    break;
                }
                cnt++;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        map[x][y] = island + 1;

        while(!q.isEmpty()) {
            Loc loc = q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = loc.x + di[i];
                int dy = loc.y + dj[i];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M && map[dx][dy] == 100) {
                    q.add(new Loc(dx, dy));
                    map[dx][dy] = island + 1;
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int next, len;

        public Edge(int next, int len) {
            this.next = next;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len -  o.len;
        }
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
