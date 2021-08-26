package BOJ;

import java.io.*;

public class Main_15990_123더하기5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[100001][3];
        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[0][0] = 1;

        int idx = 3;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            if (dp[num][0] == 0) {
                for (int i = idx; i <= num; i++) {
                    dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1000000009;
                    dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % 1000000009;
                    dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % 1000000009;
                }
            }

            int sum = ((dp[num][0] + dp[num][1]) % 1000000009 + dp[num][2]) % 1000000009;
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
