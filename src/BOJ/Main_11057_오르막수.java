package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11057_오르막수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int DIV = 10007;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % DIV;
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
            ans %= DIV;
        }

        System.out.println(ans);
        br.close();
    }
}
