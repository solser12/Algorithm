package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17267_상남자 {

    public static int N, M;
    public static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int maxLeft = Integer.parseInt(st.nextToken());
        int maxRight = Integer.parseInt(st.nextToken());

        Loc start = null;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 2) {
                    start = new Loc(i, j, maxLeft, maxRight);
                }
            }
        }

        System.out.println(bfs(start));
        br.close();
    }

    public static int bfs(Loc start) {

        Queue<Loc> q = new LinkedList<>();
        q.offer(start);
        int cnt = 1;

        while (!q.isEmpty()) {

            Loc loc = q.poll();

            int dx = loc.x;
            while (dx-- > 0) {
                if (map[dx][loc.y] != 0) {
                    break;
                }
                cnt++;
                map[dx][loc.y] = 2;
                q.offer(new Loc(dx, loc.y, loc.l, loc.r));
            }

            dx = loc.x;
            while (dx++ < N - 1) {
                if (map[dx][loc.y] != 0) {
                    break;
                }
                cnt++;
                map[dx][loc.y] = 2;
                q.offer(new Loc(dx, loc.y, loc.l, loc.r));
            }

            if (loc.l > 0) {
                int dy = loc.y - 1;
                if (0 <= dy && map[loc.x][dy] == 0) {
                    cnt++;
                    map[loc.x][dy] = 2;
                    q.offer(new Loc(loc.x, dy, loc.l - 1, loc.r));
                }
            }

            if (loc.r > 0) {
                int dy = loc.y + 1;
                if (dy < M && map[loc.x][dy] == 0) {
                    cnt++;
                    map[loc.x][dy] = 2;
                    q.offer(new Loc(loc.x, dy, loc.l, loc.r - 1));
                }
            }
        }

        return cnt;
    }

    public static class Loc {
        int x, y, l, r;

        public Loc(int x, int y, int l, int r) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.r = r;
        }
    }
}
