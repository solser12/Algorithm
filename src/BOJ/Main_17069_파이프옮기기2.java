package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17069_파이프옮기기2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[3][N][N];    // 가로 대각선 세로

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    dp[0][i][j] = -1;
                }
            }
        }

        dp[0][0][1] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 벽있으면 continue
                if (dp[0][i][j] == -1) continue;

                // 가로 이동 (가로, 대각선)
                if (j < N - 1 && dp[0][i][j+1] != -1) {
                    dp[0][i][j+1] += dp[0][i][j] + dp[1][i][j];
                }

                // 대각선 이동 (가로, 대각선, 세로)
                if (j < N - 1 && i < N - 1 && dp[0][i+1][j+1] != -1 && dp[0][i][j+1] != -1 && dp[0][i+1][j] != -1) {
                    dp[1][i+1][j+1] += dp[0][i][j] + dp[1][i][j] + dp[2][i][j];
                }

                // 세로 이동 (대각선, 세로)
                if (i < N - 1 && dp[0][i+1][j] != -1) {
                    dp[2][i+1][j] += dp[1][i][j] + dp[2][i][j];
                }
            }
        }

        long ans = dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1];
        ans = ans == -1 ? 0 : ans;
        System.out.println(ans);

        br.close();
    }
}
