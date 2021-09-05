package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11058_크리보드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        for (int i = 1; i <= Math.min(N, 6); i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
            for (int j = 2; j <= 5; j++) {
                dp[i] = Math.max(dp[i-(j+1)] * j, dp[i]);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
