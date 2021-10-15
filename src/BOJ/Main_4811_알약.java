package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4811_알약 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 30; i++) {
            long ans = 0;
            for (int j = 0; j <= (i - 1) / 2; j++) {
                ans += dp[j] * dp[i - j - 1] * (j == (i - j - 1) ? 1 : 2);
            }
            dp[i] = ans;
        }

        int T;
        while ((T = Integer.parseInt(br.readLine())) != 0) {
            sb.append(dp[T]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
