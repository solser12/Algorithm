package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {

    static int N, M;
    static boolean[][] map;
    static Loc destination;
    static int[][] dt = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        Loc start = new Loc(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1, change(Integer.parseInt(st.nextToken())));

        st = new StringTokenizer(br.readLine());
        destination = new Loc(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1, change(Integer.parseInt(st.nextToken())));

        System.out.println(bfs(start));

        br.close();
    }

    public static int bfs(Loc start) {

        boolean[][][] visited = new boolean[4][N][M];
        Queue<Loc> q = new LinkedList<>();
        visited[start.way][start.x][start.y] = true;
        q.offer(start);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();

                if (destination.sameCheck(loc)) {
                    return time;
                }

                // 이동
                int dx = loc.x;
                int dy = loc.y;
                for (int i = 0; i < 3; i++) {
                    dx += dt[loc.way][0];
                    dy += dt[loc.way][1];

                    if (!check(dx, dy) || map[dx][dy]) {
                        break;
                    }

                    if (!visited[loc.way][dx][dy]) {
                        visited[loc.way][dx][dy] = true;
                        q.offer(new Loc(dx, dy, loc.way));
                    }
                }

                // 회전
                int[] rotate = rotate(loc.way);
                for (int way : rotate) {
                    if (!visited[way][loc.x][loc.y]) {
                        visited[way][loc.x][loc.y] = true;
                        q.offer(new Loc(loc.x, loc.y, way));
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public static int[] rotate(int way) {

        int[] result = new int[2];

        result[0] = (way + 1) % 4;
        result[1] = way - 1;
        if (result[1] == -1) result[1] = 3;

        return result;
    }

    public static int change(int way) {

        int result;

        if (way == 1) result = 2;
        else if (way == 2) result = 0;
        else if (way == 3) result = 3;
        else result = 1;

        return result;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Loc {
        int x, y, way;

        public Loc(int x, int y, int way) {
            this.x = x;
            this.y = y;
            this.way = way;
        }

        public boolean sameCheck(Loc loc) {
            return this.x == loc.x && this.y == loc.y && this.way == loc.way;
        }


    }
}
