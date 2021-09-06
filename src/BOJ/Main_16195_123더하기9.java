package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16195_123더하기9 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[1001][1001];
        int[][] sum = new int[1001][1001];
        for (int i = 1; i <= 3; i++) {
            dp[1][i] = 1;
            sum[1][i] = 1;
        }
        dp[2][2] = 1;
        dp[2][3] = 2;
        dp[3][3] = 1;
        sum[2][2] = 2;
        sum[2][3] = 3;
        sum[3][3] = 4;

        for (int i = 4; i <= 1000; i++) {
            int start = ((i - 1) / 3) + 1;
            for (int j = start; j <= i; j++) {
                dp[j][i] = (dp[j-1][i-3] + dp[j-1][i-2] + dp[j-1][i-1]) % 1000000009;
                sum[j][i] = (int) ((dp[j][i] + sum[j-1][i]) % 1000000009);
            }
        }

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            sb.append(sum[max][num]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
