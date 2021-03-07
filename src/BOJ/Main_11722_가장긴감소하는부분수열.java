package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11722_가장긴감소하는부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];
        int ans;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
        }

        dp[0][1] = 1;
        ans = 1;
        for (int i = 1; i < N; i++) {
            dp[i][1] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (dp[i][0] < dp[j][0] && dp[i][1] <= dp[j][1]) {
                    dp[i][1] = dp[j][1] + 1;
                    if (ans == dp[j][1]) break;
                }
            }
            ans = Math.max(dp[i][1], ans);
        }

        System.out.println(ans);
        br.close();
    }
}
