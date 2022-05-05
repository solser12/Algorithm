package Programmers.kakao2017;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {

    boolean[][] visited;
    int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(int m, int n, int[][] picture) {

        visited = new boolean[m][n];

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) continue;
                max = Math.max(max, bfs(m, n, i, j, picture[i][j], picture));
                cnt++;
            }
        }

        int[] ans = new int[2];
        ans[0] = cnt;
        ans[1] = max;

        return ans;
    }

    public int bfs(int m, int n, int x, int y, int color, int[][] picture) {

        int count = 0;
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n
                        && picture[dx][dy] == color && !visited[dx][dy]) {
                    q.add(new Loc(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }

        return count;
    }

    public class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
