package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10422_괄호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final long MOD = 1000000007L;
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i <= 5000; i+=2) {
            int left = 0, right = i - 2;
            long ans = 0;
            while (left <= right) {
                if (left == right) ans += dp[left] * dp[right];
                else ans += dp[left] * dp[right] * 2;
                ans %= MOD;
                left += 2;
                right -= 2;
            }
            dp[i] = ans;
        }

        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
