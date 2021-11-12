package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086_아기상어2 {

    public static int N, M;
    public static boolean[][] visited;
    public static Queue<Loc> q = new LinkedList<>();
    public static int[][] dt = {{1, 0}, {1, -1}, {1, 1},  {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    visited[i][j] = true;
                    q.offer(new Loc(i, j));
                }
            }
        }

        bfs();

        br.close();
    }

    public static void bfs() {

        int len = -1;
        while (!q.isEmpty()) {
            len++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 8; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (check(dx,dy)) {
                        visited[dx][dy] = true;
                        q.offer(new Loc(dx, dy));
                    }
                }
            }
        }

        System.out.println(len);
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !visited[x][y];
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
