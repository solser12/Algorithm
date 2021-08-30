package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N+1];
        int[] dp = new int[N+1];

        wine[0] = 0;
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            wine[i] = num;

            if (i == 1) {
                dp[i] = wine[i];
            } else if (i == 2) {
                dp[i] = dp[i-1] + wine[i];
            } else {
                dp[i] = wine[i] + Math.max(dp[i-2], dp[i-3] + wine[i-1]);
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
