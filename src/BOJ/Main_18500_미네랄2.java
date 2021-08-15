package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18500_미네랄2 {

    static int R, C;
    static char[][] cave;
    static int[][] visited;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new int[R][C];
        cave = new char[R][];
        for (int i = 0; i < R; i++) {
            cave[i] = br.readLine().toCharArray();
        }

        int N = Integer.parseInt(br.readLine());
        boolean way = false;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = R - Integer.parseInt(st.nextToken());

            for (int v = 0; v < R; v++) {
                Arrays.fill(visited[v], 0);
            }

            if (shoot(height, way)) {
                if (!check()) {
                    move();
                }
            }

            way = !way;
        }

        for (char[] mineral : cave) {
            sb.append(String.valueOf(mineral)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void move() {
        Queue<Loc> temp = new LinkedList<>();
        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cave[i][j] == 'x' && visited[i][j] == 0) {
                    q.offer(new Loc(i, j));
                    temp.offer(new Loc(i, j));
                    cave[i][j] = '.';
                    visited[i][j] = 2;
                    i = R;
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if (scope(dx, dy) && cave[dx][dy] == 'x' && visited[dx][dy] == 0) {
                    q.add(new Loc(dx,dy));
                    temp.offer(new Loc(dx, dy));
                    cave[dx][dy] = '.';
                    visited[dx][dy] = 2;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            int top = -1;
            for (int j = 0; j < R; j++) {
                if (visited[j][i] == 2) top = j;

                if (visited[j][i] == 1 && top != -1) {
                    min = Math.min(min, j - top - 1);
                    break;
                }

                if (j == R - 1 && top != -1) {
                    min = Math.min(min, R - top - 1);
                }
            }
        }

        while (!temp.isEmpty()) {
            Loc loc = temp.poll();
            cave[loc.x + min][loc.y] = 'x';
        }
    }

    public static boolean check() {
        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < C; i++) {
            if (cave[R-1][i] == 'x') {
                q.offer(new Loc(R - 1, i));
                visited[R-1][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if (scope(dx, dy) && cave[dx][dy] == 'x' && visited[dx][dy] == 0) {
                    q.add(new Loc(dx,dy));
                    visited[dx][dy] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cave[i][j] == 'x' && visited[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean scope(int x, int y) {
        if (x >= 0 && x < R && y >= 0 && y < C) return true;
        return false;
    }

    public static boolean shoot(int h, boolean way) {
        int loc = way ? C - 1 : 0;
        int add = way ? -1 : 1;

        while (loc >= 0 && loc < C) {
            if (cave[h][loc] == 'x') {
                cave[h][loc] = '.';
                return true;
            }

            loc += add;
        }

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
