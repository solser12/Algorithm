package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_2Xn타일링2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        if (n == 1) {
            System.out.println(dp[1]);
        } else {
            dp[2] = 3;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
            }
            System.out.println(dp[n]);
        }

        br.close();
    }
}
