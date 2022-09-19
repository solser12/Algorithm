package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2665_미로 {

    public static int n, ans = 0;
    public static char[][] room;
    public static boolean[][] visited;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        room = new char[n][];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            room[i] = br.readLine().toCharArray();
        }

        bfs();
        System.out.println(ans);
        br.close();
    }

    public static void bfs() {

        PriorityQueue<Loc> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        pq.offer(new Loc(0, 0, 0));

        while (!pq.isEmpty()) {
            Loc loc = pq.poll();
            if (visited[loc.x][loc.y]) {
                continue;
            }
            visited[loc.x][loc.y] = true;

            if (loc.x == n - 1 && loc.y == n - 1) {
                ans = loc.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    pq.offer(new Loc(dx, dy, loc.cnt + (room[dx][dy] == '1' ? 0 : 1)));
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n && !visited[x][y];
    }

    public static class Loc implements Comparable<Loc> {
        int x, y, cnt;

        public Loc(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Loc o) {
            return this.cnt - o.cnt;
        }
    }
}
