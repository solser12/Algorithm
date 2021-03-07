package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int [N][N][3];  // 가로, 대각선, 세로

        for (int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    dp[i][j][0] = -1;
                    dp[i][j][1] = -1;
                    dp[i][j][2] = -1;
                }
            }
        }

        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (dp[i][j][0] == -1) continue;
                if (j < N-1 && dp[i][j+1][0] != -1) {
                    dp[i][j+1][0] += dp[i][j][0];
                    dp[i][j+1][0] += dp[i][j][1];
                }

                if (i < N-1 && dp[i+1][j][0] != -1) {
                    dp[i+1][j][2] += dp[i][j][1];
                    dp[i+1][j][2] += dp[i][j][2];
                }

                if (i < N-1 && j < N-1 && dp[i+1][j][0] != -1 && dp[i][j+1][0] != -1 && dp[i+1][j+1][0] != -1) {
                    dp[i+1][j + 1][1] += dp[i][j][0];
                    dp[i+1][j + 1][1] += dp[i][j][1];
                    dp[i+1][j + 1][1] += dp[i][j][2];
                }
            }
        }

        int ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        ans = ans <= 0 ? 0 : ans;
        System.out.println(ans);
        br.close();
    }
}
