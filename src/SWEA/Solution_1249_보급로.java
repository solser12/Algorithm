package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1249_보급로 {

    static int N, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j) - 48;
                }
            }
            bfs();
            sb.append("#").append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void bfs() {
        PriorityQueue<Loc> q = new PriorityQueue<>();
        q.add(new Loc(0, 0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = di[d] + loc.x;
                int dy = dj[d] + loc.y;
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visit[dx][dy]) {
                    if (dx == N - 1 && dy == N -1) {
                        ans = loc.cost;
                        return;
                    }
                    visit[dx][dy] = true;
                    q.add(new Loc(dx, dy, loc.cost + map[dx][dy]));
                }
            }
        }
    }

    static class Loc implements Comparable<Loc> {
        int x, y, cost;

        public Loc(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Loc o) {
            return this.cost - o.cost;
        }
    }
}
