package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁전투 {

    public static int n, m, w = 0, b = 0;
    public static char[][] map;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '-') {
                    bfs(i, j, map[i][j]);
                }
            }
        }

        System.out.printf("%d %d", w, b);
        br.close();
    }

    public static void bfs(int x, int y, char color) {

        int count = 1;
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        map[x][y] = '-';

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy, color)) {
                    count++;
                    q.offer(new Loc(dx, dy));
                    map[dx][dy] = '-';
                }
            }
        }

        if (color == 'W') {
            w += count * count;
        } else {
            b += count * count;
        }
    }

    public static boolean check(int x, int y, char color) {
        return 0 <= x && x < n && 0 <= y && y < m && map[x][y] == color;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
