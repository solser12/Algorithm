package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16173_점프왕쩰리small {

    public static int n;
    public static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? "HaruHaru" : "Hing");

        br.close();
    }

    public static boolean bfs() {

        Queue<Loc> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new Loc(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            if (loc.x == n - 1 && loc.y == n - 1) {
                return true;
            }

            int dx = loc.x + map[loc.x][loc.y];
            int dy = loc.y + map[loc.x][loc.y];

            if (check(loc.x, dy, visited)) {
                q.offer(new Loc(loc.x, dy));
                visited[loc.x][dy] = true;
            }

            if (check(dx, loc.y, visited)) {
                q.offer(new Loc(dx, loc.y));
                visited[dx][loc.y] = true;
            }
        }

        return false;
    }

    public static boolean check(int x, int y, boolean[][] visited) {
        return 0 <= x && x < n && 0 <= y && y < n && !visited[x][y];
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
