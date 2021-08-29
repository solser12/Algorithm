package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10844_쉬운계단수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N-1][i];
            ans %= 1000000000;
        }

        System.out.println(ans);
        br.close();
    }
}
