package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21736_헌내기는친구가필요해 {

    public static int n, m;
    public static char[][] campus;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        Loc start = null;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = input.charAt(j);
                if (campus[i][j] == 'I') {
                    campus[i][j] = 'X';
                    start = new Loc(i, j);
                }
            }
        }

        int cnt = bfs(start);

        System.out.println(cnt == 0 ? "TT" : cnt);
        br.close();
    }

    public static int bfs(Loc start) {

        Queue<Loc> q = new LinkedList<>();
        q.offer(start);

        int ans = 0;
        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    if (campus[dx][dy] == 'P') {
                        ans++;
                    }
                    campus[dx][dy] = 'X';
                    q.offer(new Loc(dx, dy));
                }
            }
        }

        return ans;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && campus[x][y] != 'X';
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
