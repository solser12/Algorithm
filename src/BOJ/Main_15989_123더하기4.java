package BOJ;

import java.io.*;

public class Main_15989_123더하기4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp = new int[10001][2];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 1;

        int T = Integer.parseInt(br.readLine());
        int idx = 4;
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());

            if (dp[num][0] == 0) {
                for (int i = idx; i <= num; i++) {
                    dp[i][0] = dp[i-1][0] + dp[i-1][1];
                    dp[i][1] = dp[i-2][1];
                    if (i % 3 == 0) dp[i][1] += 1;
                }

                idx = num + 1;
            }

            bw.write((dp[num][0] + dp[num][1]) + "\n");
        }

        bw.close();
        br.close();
    }
}
