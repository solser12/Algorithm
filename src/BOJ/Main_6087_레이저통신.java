package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6087_레이저통신 {

    // 상 0 좌 1 하 2 우 3
    static int W, H, ans;
    static char[][] map;
    static int[][][] visited;
    static int[][] dt = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] dway = {{0, 1, 3}, {1, 0, 2}, {2, 1, 3}, {3, 0, 2}};
    static ArrayList<Loc> lasers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new int[4][H][W];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < H; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (input[j] == 'C') {
                    lasers.add(new Loc(i, j));
                }
                map[i][j] = input[j];
            }
        }

        map[lasers.get(1).x][lasers.get(1).y] = '.';
        bfs();

        System.out.println(ans);
        br.close();
    }

    static void bfs() {
        int cX = lasers.get(1).x;
        int cY = lasers.get(1).y;

        PriorityQueue<Loc> q = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            int dx = lasers.get(0).x + dt[i][0];
            int dy = lasers.get(0).y + dt[i][1];

            if (dx < 0 || dx >= H || dy < 0 || dy >= W || map[dx][dy] != '.') continue;

            q.add(new Loc(dx, dy, i, 0));
            visited[i][dx][dy] = 0;
        }

        while (!q.isEmpty()) {
            Loc loc = q.poll();

            if (loc.x == cX && loc.y == cY) {
                ans = loc.count;
                return;
            }

            for (int d = 0; d < 3; d++) {
                int dx = loc.x + dt[dway[loc.way][d]][0];
                int dy = loc.y + dt[dway[loc.way][d]][1];

                // 조건 검사
                if (dx < 0 || dx >= H || dy < 0 || dy >= W || map[dx][dy] != '.') continue;
                // 방향 틀면 count + 1
                int cnt = d == 0 ? loc.count : loc.count + 1;
                // 진행 방향
                int way = dway[loc.way][d];
                // 큐에 넣기 전에 기존 방문 확인
                if (visited[way][dx][dy] <= cnt) continue;
                // 방문처리
                visited[way][dx][dy] = cnt;

                q.add(new Loc(dx, dy, way, cnt));
            }
        }
    }

    static class Loc implements Comparable<Loc> {
        int x, y, way, count;

        public Loc(int x, int y, int way, int count) {
            this.x = x;
            this.y = y;
            this.way = way;
            this.count = count;
        }

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Loc o) {
            return this.count - o.count;
        }
    }
}

