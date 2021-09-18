package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1890_점프 {

    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(find(0, 0));
        br.close();
    }

    public static long find(int x, int y) {

        if (x == N - 1 && y == N - 1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        int dx = x + map[x][y];
        int dy = y + map[x][y];

        if (dx < N) {
            dp[x][y] += find(dx, y);
        }

        if (dy < N) {
            dp[x][y] += find(x, dy);
        }

        return dp[x][y];
    }
}
