package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743_음식물피하기 {

    public static int n, m;
    public static boolean[][] map;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static int bfs(int x, int y) {

        int result = 1;
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        map[x][y] = false;

        while (!q.isEmpty()) {
            Loc now = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = dt[d][0] + now.x;
                int dy = dt[d][1] + now.y;
                if (check(dx, dy)) {
                    map[dx][dy] = false;
                    q.offer(new Loc(dx, dy));
                    result++;
                }
            }
        }

        return result;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && map[x][y];
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
