package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3108_로고 {

    public static final int DEFAULT = 1000, SIZE = 2001;
    public static boolean[][] monitor = new boolean[SIZE][SIZE];
    public static boolean[][] visited = new boolean[SIZE][SIZE];
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            draw(new Vertex(x1, y1, x2, y2));
        }

        int ans = monitor[1000][1000] ? -1 : 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (monitor[i][j] && !visited[i][j]) {
                    bfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    q.offer(new Loc(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && !visited[x][y] && monitor[x][y];
    }

    public static void draw(Vertex vertex) {
        for (int i = vertex.loc1.x; i <= vertex.loc2.x; i++) {
            monitor[i][vertex.loc1.y] = true;
            monitor[i][vertex.loc2.y] = true;
        }

        for (int i = vertex.loc1.y; i <= vertex.loc2.y; i++) {
            monitor[vertex.loc1.x][i] = true;
            monitor[vertex.loc2.x][i] = true;
        }
    }

    public static class Vertex {
        Loc loc1, loc2;

        public Vertex(int x1, int y1, int x2, int y2) {
            this.loc1 = new Loc(Math.min(x1, x2) * 2 + DEFAULT, Math.min(y1, y2) * 2 + DEFAULT);
            this.loc2 = new Loc(Math.max(x1, x2) * 2 + DEFAULT, Math.max(y1, y2) * 2 + DEFAULT);
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
