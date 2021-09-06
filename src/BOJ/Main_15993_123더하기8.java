package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15993_123더하기8 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[2][100001];
        dp[1][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 1;

        for (int i = 3; i <= 100000; i++) {
            dp[0][i] = (dp[1][i-3] + dp[1][i-2] + dp[1][i-1]) % 1000000009;
            dp[1][i] = (dp[0][i-3] + dp[0][i-2] + dp[0][i-1]) % 1000000009;
        }

        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[0][num]).append(' ').append(dp[1][num]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
