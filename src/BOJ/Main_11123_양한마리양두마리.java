package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11123_양한마리양두마리 {

    public static int H, W;
    public static char[][] map;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '#') {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static void bfs(int x, int y) {

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        map[x][y] = '.';

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    map[dx][dy] = '.';
                    q.offer(new Loc(dx, dy));
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W && map[x][y] == '#';
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
