package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {

    public static int N, L, R;
    public static boolean move;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        int ans = 0;
        while (true) {
            move = false;
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (bfs(i, j)) {
                        move = true;
                    }
                }
            }

            if (move) ans++;
            else break;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean bfs(int x, int y) {
        LinkedList<Loc> temp = new LinkedList<>();
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        visited[x][y] = true;
        int total = map[x][y];
        int cnt = 1;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            temp.add(loc);
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy) && !visited[dx][dy]) {
                    int diff = Math.abs(map[loc.x][loc.y] - map[dx][dy]);
                    if (L <= diff && diff <= R) {
                        q.offer(new Loc(dx, dy));
                        visited[dx][dy] = true;
                        total += map[dx][dy];
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 1) return false;

        int avg = total / cnt;
        for (Loc loc : temp) {
            map[loc.x][loc.y] = avg;
        }
        return true;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
