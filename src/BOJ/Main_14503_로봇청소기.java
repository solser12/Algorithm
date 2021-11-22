package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

    public static int N, M, ans = 0;
    public static int[][] room;
    public static Robot robot;
    public static int[][] dt = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int way = Integer.parseInt(st.nextToken());
        way = way == 1 ? 3 : (way == 3 ? 1 : way);
        robot = new Robot(r, c, way);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            robot.clear();
        } while (robot.move());

        System.out.println(ans);
        br.close();
    }

    public static class Robot {
        int x, y, way;

        public Robot(int x, int y, int way) {
            this.x = x;
            this.y = y;
            this.way = way;
        }

        public void clear() {
            if (room[x][y] == 0) {
                room[x][y] = -1;
                ans++;
            }
        }

        public boolean move() {

            // a, b
            for (int i = 0; i < 4; i++) {
                way = (way + 1) % 4;
                int dx = x + dt[way][0];
                int dy = y + dt[way][1];
                if (check(dx, dy) && room[dx][dy] == 0) {
                    x = dx;
                    y = dy;
                    return true;
                }
            }

            // c
            int back = (way + 2) % 4;
            int dx = x + dt[back][0];
            int dy = y + dt[back][1];
            if (check(dx, dy) && room[dx][dy] != 1) {
                x = dx;
                y = dy;
                return true;
            }

            return false;
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 &&  x < N && y >= 0 && y < M;
    }
}
