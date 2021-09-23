package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {

    static int n, ans = 0;
    static int[][] map, dp;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, find(i, j));
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static int find(int x, int y) {

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int dx = x + dt[d][0];
            int dy = y + dt[d][1];
            if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                int ret;
                if (map[x][y] < map[dx][dy]) {
                    ret = find(dx, dy) + 1;
                } else {
                    ret = 1;
                }
                dp[x][y] = Math.max(dp[x][y], ret);
            }
        }

        return dp[x][y];
    }
}

