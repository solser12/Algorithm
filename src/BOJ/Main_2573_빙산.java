package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {

    static int[][] map;
    static int N, M;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
            }
        }

        int year = 1;
        while (true) {

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] > 0) {
                        melt(i, j);
                        i = N;
                        break;
                    }
                }
            }

            int result = check();
            if (result != 1) {
                if (result == 0) year = 0;
                break;
            }

            year++;
        }

        System.out.println(year);
        br.close();
    }

    public static void melt(int x, int y) {

        int[][] temp = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();

            int height = map[loc.x][loc.y];

            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if (map[dx][dy] == 0) {
                    height--;
                } else if (map[dx][dy] > 0 && !visited[dx][dy]) {
                    q.add(new Loc(dx, dy));
                    visited[dx][dy] = true;
                }
            }

            temp[loc.x][loc.y] = Math.max(height, 0);
        }

        map = temp;
    }

    public static int check() {

        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    if (cnt == 0) {
                        find(visited, i, j);
                        cnt++;
                    } else {
                        return 2;
                    }
                }
            }
        }

        return cnt;
    }

    public static void find(boolean[][] visited, int x, int y) {

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (map[dx][dy] > 0 && !visited[dx][dy]) {
                    q.add(new Loc(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
