package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {

    public static int n, m;
    public static int[][] map;
    public static int[][] result;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];

        Loc loc = null;
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    loc = new Loc(i, j);
                } else if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        bfs(loc);

        StringBuilder sb = new StringBuilder();
        for (int[] a : result) {
            for (int b : a) {
                sb.append(b).append(' ');
            }
            sb.setLength(sb.length() - 1);
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs(Loc loc) {

        Queue<Loc> q = new LinkedList<>();
        q.offer(loc);
        result[loc.x][loc.y] = 0;

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = now.x + dt[d][0];
                    int dy = now.y + dt[d][1];
                    if (check(dx, dy)) {
                        q.offer(new Loc(dx, dy));
                        result[dx][dy] = step;
                    }
                }
            }
            step++;
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && result[x][y] == -1 && map[x][y] == 1;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
