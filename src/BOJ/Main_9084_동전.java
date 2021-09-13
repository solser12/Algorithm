package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9084_동전 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int money = Integer.parseInt(br.readLine());

            int[][] dp = new int[N][money+1];
            for (int i = 0; i < N; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= money; i++) {
                for (int j = 0; j < N; j++) {
                    if (coin[j] > i) {
                        if (j != 0) {
                            dp[j][i] = dp[j - 1][i];
                        }
                        continue;
                    }
                    dp[j][i] = dp[j][i - coin[j]] + (j == 0 ? 0 : dp[j - 1][i]);
                }
            }

            sb.append(dp[N-1][money]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
