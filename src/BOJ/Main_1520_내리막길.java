package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        System.out.println(dfs(0, 0));
        br.close();
    }

    static int dfs(int x, int y) {
        int ret = 0;

        if (x == N-1 && y == M-1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        for (int d = 0; d < 4; d++) {
            int dx = x + di[d];
            int dy = y + dj[d];
            if (dx >= 0 && dx < N && dy >= 0 && dy < M && map[x][y] > map[dx][dy]) {
                ret += dfs(dx, dy);
            }
        }
        dp[x][y] = ret;
        return ret;
    }
}
