package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

    static int N, M, cnt, time;
    static int[][] map;
    static int[][] di = {{}, {1, -1, 0, 0}, {1, -1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
    static int[][] dj = {{}, {0, 0, 1, -1}, {0, 0}, {1, -1}, {0, 1}, {0, 1}, {0 ,-1}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cnt = 0;

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            time = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            findPrisoner(startX, startY);

            sb.append('#').append(t).append(' ').append(cnt).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void findPrisoner(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        visit[x][y] = true;
        cnt++;
        time--;

        while(!q.isEmpty()) {
            if (time == 0) return;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                int type = map[loc.x][loc.y];
                for (int d = 0; d < di[type].length; d++) {
                    int dx = loc.x + di[type][d];
                    int dy = loc.y + dj[type][d];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M && map[dx][dy] != 0
                            && check(loc, dx, dy) && !visit[dx][dy]) {
                        q.add(new Loc(dx, dy));
                        visit[dx][dy] = true;
                        cnt++;
                    }
                }
            }
            time--;
        }
    }

    static boolean check(Loc loc, int x, int y) {
        int type = map[x][y];
        for (int d = 0; d < di[type].length; d++) {
            int dx = x + di[type][d];
            int dy = y + dj[type][d];
            if (loc.x == dx && loc.y == dy) return true;
        }
        return false;
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
