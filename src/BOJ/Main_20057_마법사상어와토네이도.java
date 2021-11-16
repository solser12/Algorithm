package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {

    public static int N, ans = 0;
    public static int[][] map;
    public static int[][] dt = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public static int[][][] windDt =
            {{{-1, 1, 1}, {1, 1, 1}, {-1, 0, 7}, {1, 0, 7}, {2, 0, 2}, {-2, 0, 2}, {-1, -1, 10}, {1, -1, 10}, {0, -2, 5}},
            {{-1, -1, 1}, {-1, 1, 1}, {0, -1, 7}, {0, 1, 7}, {0, -2, 2}, {0, 2, 2}, {1, -1, 10}, {1, 1, 10}, {2, 0, 5}},
            {{-1, -1, 1}, {1, -1, 1}, {-1, 0, 7}, {1, 0, 7}, {-2, 0, 2}, {2, 0, 2}, {-1, 1, 10}, {1, 1, 10}, {0, 2, 5}},
            {{1, -1, 1}, {1, 1, 1}, {0, -1, 7}, {0, 1, 7}, {0, -2, 2}, {0, 2, 2}, {-1, -1, 10}, {-1, 1, 10}, {-2, 0, 5}}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start();

        System.out.println(ans);
        br.close();
    }

    public static void start() {

        Tornado tornado = new Tornado(N / 2);
        for (int i = 1; i < N * N; i++) {
            Wind wind = tornado.move();
            int totalSand = 0;
            for (int[] way : windDt[wind.way]) {
                int dx = wind.loc.x + way[0];
                int dy = wind.loc.y + way[1];
                int sand = (int) ((map[wind.loc.x][wind.loc.y] / 100.0) * way[2]);
                totalSand += sand;
                if (check(dx, dy)) {
                    map[dx][dy] += sand;
                } else {
                    ans += sand;
                }
            }

            int dx = wind.loc.x + dt[wind.way][0];
            int dy = wind.loc.y + dt[wind.way][1];
            if (check(dx, dy)) {
                map[dx][dy] += map[wind.loc.x][wind.loc.y] - totalSand;
            } else {
                ans += map[wind.loc.x][wind.loc.y] - totalSand;
            }
            map[wind.loc.x][wind.loc.y] = 0;
        }
    }

    public static class Tornado {
        Loc loc;
        int way = 0, moveCnt = 0, totalMove = 1, totalCnt = 0;

        public Tornado(int start) {
            this.loc = new Loc(start, start);
        }

        public Wind move() {
            loc.x += dt[way][0];
            loc.y += dt[way][1];
            moveCnt++;
            Wind wind = new Wind(loc, way);

            if (moveCnt == totalMove) {
                moveCnt = 0;
                totalCnt++;
                way = (way + 1) % 4;
                if (totalCnt == 2) {
                    totalMove++;
                    totalCnt = 0;
                }
            }

            return wind;
        }
    }

    public static class Wind {
        Loc loc;
        int way;

        public Wind(Loc loc, int way) {
            this.loc = loc;
            this.way = way;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
