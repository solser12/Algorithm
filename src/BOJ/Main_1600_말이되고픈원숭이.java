package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {

    static int K, H, W;
    static boolean[][][] visited;
    static int[][] map;
    static int[][] monkey = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] horse = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[K+1][H][W];
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 0));
        visited[0][0][0] = true;

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                if (loc.x == H - 1 && loc.y == W - 1) return step;

                // horse
                if (loc.cnt < K) {
                    for (int d = 0; d < 8; d++) {
                        int dx = loc.x + horse[d][0];
                        int dy = loc.y + horse[d][1];
                        int cnt = loc.cnt + 1;
                        if (check(dx, dy, cnt)) {
                            q.add(new Loc(dx, dy, cnt));
                            visited[cnt][dx][dy] = true;
                        }
                    }
                }

                // monkey
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + monkey[d][0];
                    int dy = loc.y + monkey[d][1];
                    if (check(dx, dy, loc.cnt)) {
                        q.add(new Loc(dx, dy, loc.cnt));
                        visited[loc.cnt][dx][dy] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public static boolean check(int dx, int dy, int cnt) {
        return dx >= 0 && dx < H && dy >= 0 && dy < W && !visited[cnt][dx][dy] && map[dx][dy] == 0;
    }

    public static class Loc {
        int x, y, cnt;

        public Loc(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}