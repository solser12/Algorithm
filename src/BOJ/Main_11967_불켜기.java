package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11967_불켜기 {

    static int N, M, ans = 1;
    static ArrayList<Loc>[][] map;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0 ,1}};
    static int[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        visited = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            if (map[x1][y1] == null) {
                map[x1][y1] = new ArrayList<>();
            }

            map[x1][y1].add(new Loc(x2, y2));
        }

        bfs();

        System.out.println(ans);
        br.close();
    }

    public static void bfs() {

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0));
        visited[0][0] = 3;

        while (!q.isEmpty()) {
            Loc loc = q.poll();

            // 갈수있는곳 표시하기
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
                    if (visited[dx][dy] == 0) {
                        // 갈 수 있는데 어두워서 못감
                        visited[dx][dy] = 1;
                    } else if (visited[dx][dy] == 2) {
                        // 불이 켜져있음
                        visited[dx][dy] = 3;
                        q.add(new Loc(dx, dy));
                    }
                }
            }

            // 불켜기
            if (map[loc.x][loc.y] == null) continue;
            for (Loc on : map[loc.x][loc.y]) {
                if (visited[on.x][on.y] == 1) {
                    // 갈 수 있는데 어두 워서 못간 부분
                    visited[on.x][on.y] = 3;
                    q.add(new Loc(on.x, on.y));
                } else if (visited[on.x][on.y] == 0) {
                    // 불 켜기
                    visited[on.x][on.y] = 2;
                } else {
                    continue;
                }

                ans++;
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
