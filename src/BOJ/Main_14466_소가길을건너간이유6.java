package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14466_소가길을건너간이유6 {

    static int N, K, R, sum = 0, ans = 0;
    static int[][] farm;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static ArrayList<Loc> cows = new ArrayList<>();
    static ArrayList<Integer> sumList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        farm = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            int idx1 = 1, idx2 = 2;
            if (r1 > r2) {
                farm[r1][c1] |= idx1;
                farm[r2][c2] |= idx2;
            } else if (r1 < r2) {
                farm[r1][c1] |= idx2;
                farm[r2][c2] |= idx1;
            } else {
                idx1 = 4;
                idx2 = 8;
                if (c1 > c2) {
                    farm[r1][c1] |= idx1;
                    farm[r2][c2] |= idx2;
                } else {
                    farm[r1][c1] |= idx2;
                    farm[r2][c2] |= idx1;
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            cows.add(new Loc(x, y));
            map[x][y] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < sumList.size() - 1; i++) {
            sum -= sumList.get(i);
            ans += sum * sumList.get(i);
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs(int x, int y) {

        int cnt = 1;
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        map[x][y] = 2;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int idx = 1 << d;
                if ((farm[loc.x][loc.y] & idx) > 0) {
                    continue;
                }

                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] != 2) {
                    if (map[dx][dy] == 1) {
                        cnt++;
                    }
                    map[dx][dy] = 2;
                    q.offer(new Loc(dx, dy));
                }
            }
        }

        sumList.add(cnt);
        sum += cnt;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
