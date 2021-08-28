package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13398_연속합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[2][n+1];
        int ans = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (dp[0][i-1] < 0) dp[0][i] = num;
            else dp[0][i] = dp[0][i-1] + num;

            if (i == 1) dp[1][i] = num;
            else if (num < 0) dp[1][i] = Math.max(dp[1][i-1] + num, dp[0][i-1]);
            else dp[1][i] = dp[1][i-1] + num;

            ans = max(dp[0][i], dp[1][i], ans);
        }

        System.out.println(ans);
        br.close();
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
