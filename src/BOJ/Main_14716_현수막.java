package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14716_현수막 {

    public static int[][] banner;
    public static int m, n;
    public static int[][] dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        banner = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (banner[i][j] == 1) {
                    bfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs(int x, int y) {

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        banner[x][y] = 0;
        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 8; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    banner[dx][dy] = 0;
                    q.offer(new Loc(dx, dy));
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n && banner[x][y] == 1;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
