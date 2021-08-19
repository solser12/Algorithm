package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1256_사전 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N + M][2];
        int max = N + M - 1;
        int idx = N + M - 1;

        for (int i = M - 1; i >= 0; i--) {
            int div = 0;
            for (int j = i; j <= max; j++) {
                if (j == i) {
                    dp[j][0] = 1;
                    dp[j][1] = 1;
                } else {
                    dp[j][0] = dp[j-1][0] * j / div;
                    dp[j][1] = dp[j][0] + dp[j-1][1];
                }

                if (dp[j][1] >= K) {
                    for (;idx > j; idx--) {
                        sb.append('a');
                    }
                    sb.append('z');

                    if (i == 0) {
                        while (idx > 0) {
                            sb.append('a');
                            idx--;
                        }
                        break;
                    }

                    max = j - 1;
                    idx = max;
                    K -= dp[j-1][1];
                    break;
                }

                div++;

                // 계산이 너무 크면
                if (j == max || dp[j][1] > 1000000000) {
                    i = -1;
                    sb.append(-1);
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
