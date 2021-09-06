package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15992_123더하기7 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[1001][1001];
        for (int i = 1; i <= 3; i++) {
            dp[1][i] = 1;
        }
        dp[2][2] = 1;
        dp[2][3] = 2;
        dp[3][3] = 1;

        int last = 3;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n > last) {
                for (int i = last + 1; i <= n; i++) {
                    int start = ((i - 1) / 3) + 1;
                    for (int j = start; j <= i; j++) {
                        dp[j][i] = ((dp[j-1][i-3] + dp[j-1][i-2]) % 1000000009 + dp[j-1][i-1]) % 1000000009;
                    }
                }
                last = n;
            }

            sb.append(dp[m][n]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
