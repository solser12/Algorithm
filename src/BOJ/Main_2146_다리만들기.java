package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {

    public static int N, ans = Integer.MAX_VALUE;
    public static int[][] map;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    findIsland(i, j);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void findIsland(int x, int y) {

        Queue<Loc> island = new LinkedList<>();
        map[x][y] = 2;
        island.offer(new Loc(x, y));

        Queue<Loc> bridge = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        while (!island.isEmpty()) {
            Loc loc = island.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    if (map[dx][dy] == 1) {
                        island.offer(new Loc(dx, dy));
                        map[dx][dy] = 2;
                    } else if (map[dx][dy] == 0 && !visited[dx][dy]) {
                        bridge.offer(new Loc(dx, dy));
                        visited[dx][dy] = true;
                    }
                }
            }
        }

        makeBridge(bridge, visited);
    }

    public static void makeBridge(Queue<Loc> bridge, boolean[][] visited) {

        int cnt = 1;
        while (!bridge.isEmpty() && cnt < ans) {
            int size = bridge.size();
            for (int s = 0; s < size; s++) {
                Loc loc = bridge.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (check(dx, dy)) {
                        if (map[dx][dy] == 0 && !visited[dx][dy]) {
                            bridge.offer(new Loc(dx, dy));
                            visited[dx][dy] = true;
                        } else if (map[dx][dy] == 1) {
                            ans = cnt;
                            return;
                        }
                    }
                }
            }
            cnt++;
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}