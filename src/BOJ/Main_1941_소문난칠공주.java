package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941_소문난칠공주 {

    static int N = 5, ans = 0;
    static boolean[][] visited = new boolean[N][N];
    static char[][] map = new char[N][N];
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(ans);
        br.close();
    }

    public static void dfs(int depth, int num, int dasom, int doyeon) {

        if (doyeon >= 4) return;

        if (depth == 7) {
            if (check()) {
                ans++;
            }
            return;
        }

        for (int i = num; i < 25 - (6 - depth); i++) {
            int x = i / 5;
            int y = i % 5;

            visited[x][y] = true;
            if (map[x][y] == 'Y') {
                dfs(depth + 1, i + 1, dasom, doyeon + 1);
            } else {
                dfs(depth + 1, i + 1, dasom + 1, doyeon);
            }
            visited[x][y] = false;
        }
    }

    public static boolean check() {
        int count = 1;

        boolean[][] temp = new boolean[5][];
        for (int i = 0; i < 5; i++) {
            temp[i] = visited[i].clone();
        }

        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    q.offer(new Loc(i, j));
                    temp[i][j] = false;
                    i = 5;
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && temp[dx][dy]) {
                    temp[dx][dy] = false;
                    q.offer(new Loc(dx, dy));
                    count++;
                }
            }
        }

        return count == 7;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
