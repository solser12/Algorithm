package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1245_농장_관리 {

    static int N, M, ans = 0, minHeight = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                bfs(i, j , map[i][j]);
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs(int x, int y, int height) {

        Queue<Loc> q = new LinkedList<>();
        boolean topFlag = true;
        q.add(new Loc(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc poll = q.poll();
            for (int d = 0; d < 8; d++) {
                int dx = poll.x + dt[d][0];
                int dy = poll.y + dt[d][1];
                if (check(dx, dy)) {
                    if (map[dx][dy] > height) {
                        topFlag = false;
                    } else if (!visited[dx][dy] && map[dx][dy] == height) {
                        visited[dx][dy] = true;
                        q.add(new Loc(dx, dy));
                    }
                }
            }
        }

        if (topFlag && height > minHeight) ans++;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
