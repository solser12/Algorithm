package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13565_침투 {

    public static int n, m;
    public static int[][] fiber;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fiber = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                fiber[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs() ? "YES" : "NO");
        br.close();
    }

    public static boolean bfs() {
        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (fiber[0][i] == 0) {
                q.offer(new Loc(0, i));
                fiber[0][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            if (loc.x == n - 1) {
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    q.offer(new Loc(dx, dy));
                    fiber[dx][dy] = 1;
                }
            }
        }

        return false;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && fiber[x][y] == 0;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
