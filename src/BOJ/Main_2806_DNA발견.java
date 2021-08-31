package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2806_DNA발견 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String dna = br.readLine();
        int[][] dp = new int[2][N];

        if (dna.charAt(0) == 'A') {
            dp[0][0] = 0;
            dp[1][0] = 1;
        } else {
            dp[0][0] = 1;
            dp[1][0] = 0;
        }

        for (int i = 1; i < N; i++) {
            char c = dna.charAt(i);

            if (c == 'A') {
                dp[0][i] = dp[0][i-1];
                dp[1][i] = Math.min(dp[1][i-1] + 1, dp[0][i] + 1);
            } else {
                dp[1][i] = dp[1][i-1];
                dp[0][i] = Math.min(dp[0][i-1] + 1, dp[1][i] + 1);
            }
        }

        int ans = Math.min(dp[0][N-1], dp[1][N-1] + 1);
        System.out.println(ans);
        br.close();
    }
}
