package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14923_미로탈출 {

    static int N, M, Hx, Hy, Ex, Ey;
    static boolean[][] map;
    static int[][] dt = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken()) - 1;
        Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken()) - 1;
        Ey = Integer.parseInt(st.nextToken()) - 1;

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map[i][j] = true;
                }
            }
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {

        boolean[][][] visited = new boolean[2][N][M];
        Queue<Loc> q = new LinkedList<>();
        visited[0][Hx][Hy] = true;
        q.offer(new Loc(Hx, Hy, true));

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                if (loc.check()) return time;
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (check(dx, dy)) {
                        if (loc.wand) {
                            if (map[dx][dy] && !visited[1][ dx][dy]) {
                                visited[1][dx][dy] = true;
                                q.add(new Loc(dx, dy, false));
                            } else if (!map[dx][dy] && !visited[0][dx][dy]){
                                visited[0][dx][dy] = true;
                                q.add(new Loc(dx, dy, true));
                            }
                        } else {
                            if (!map[dx][dy] && !visited[1][dx][dy]) {
                                visited[1][dx][dy] = true;
                                q.add(new Loc(dx, dy, false));
                            }
                        }
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Loc {
        int x, y;
        boolean wand;

        public Loc(int x, int y, boolean wand) {
            this.x = x;
            this.y = y;
            this.wand = wand;
        }

        public boolean check() {
            return this.x == Ex && this.y == Ey;
        }
    }
}
