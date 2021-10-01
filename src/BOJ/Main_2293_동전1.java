package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293_동전1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][k+1];
        int[] coin = new int[n];
        int[] sum = new int[k+1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) {
                    sum[i-coin[j]] += dp[j][i-coin[j]];
                    dp[j][i] = sum[i-coin[j]];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i][k];
        }

        System.out.println(ans);
        br.close();
    }
}
