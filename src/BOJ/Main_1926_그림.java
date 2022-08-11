package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {

    public static int n, m;
    public static int[][] paper;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    max = Math.max(max, bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
        br.close();
    }

    public static int bfs(int x, int y) {

        int result = 1;
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        paper[x][y] = 0;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    paper[dx][dy] = 0;
                    q.offer(new Loc(dx, dy));
                    result++;
                }
            }
        }

        return result;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && paper[x][y] == 1;
    }

    public static class Loc {

        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
