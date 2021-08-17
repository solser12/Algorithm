package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2234_성벽 {

    static int n, m, idx = 1, max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
    static int[][] map, mark;
    static int[][] dt = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static ArrayList<Integer> count = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mark[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        sb.append(count.size()).append('\n').append(max).append('\n').append(max2);
        System.out.println(sb);
        br.close();
    }

    public static void bfs(int x, int y) {

        int lastMax = 0;
        int cnt = 1;
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        mark[x][y] = idx;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if ((map[loc.x][loc.y] & (1 << d)) == 0) {
                    if (check(dx, dy) && mark[dx][dy] == 0) {
                        q.add(new Loc(dx, dy));
                        mark[dx][dy] = idx;
                        cnt++;
                    }
                } else {
                    if (check(dx, dy) && mark[dx][dy] != 0 && mark[dx][dy] != idx) {
                        lastMax = Math.max(count.get(mark[dx][dy] - 1), lastMax);
                    }
                }
            }
        }

        idx++;
        count.add(cnt);
        max = Math.max(cnt, max);
        max2 = Math.max(cnt + lastMax, max2);
    }

    public static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
