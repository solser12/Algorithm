package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        return bfs(n, m, maps, visited);
    }

    public int bfs(int n, int m, int[][] maps, boolean[][] visited) {

        int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(0, 0));
        visited[0][0] = true;

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                if (loc.x == n - 1 && loc.y == m - 1) {
                    return step;
                }

                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (check(n, m, dx, dy, visited, maps)) {
                        visited[dx][dy] = true;
                        q.offer(new Loc(dx, dy));
                    }
                }
            }

            step++;
        }

        return -1;
    }

    public boolean check(int n, int m, int x, int y, boolean[][] visited, int[][] maps) {
        return 0 <= x && x < n && 0 <= y && y < m && !visited[x][y] && maps[x][y] == 1;
    }

    public class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
