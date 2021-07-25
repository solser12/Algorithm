package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15988_123더하기3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[1000001];
        int idx = 4;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) sb.append(dp[1]);
            else if (n == 2) sb.append(dp[2]);
            else {
                while (idx <= n) {
                    dp[idx] = (dp[idx - 1] + dp[idx - 2] + dp[idx - 3]) % 1000000009;
                    idx++;
                }

                sb.append(dp[n]);
            }

            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
