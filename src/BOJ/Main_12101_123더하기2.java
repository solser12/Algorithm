package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12101_123더하기2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        if (dp[n] < k) {
            System.out.println(-1);
        } else {
            int idx = n;
            int num = k;
            while (idx != 0) {
                int one = dp[idx - 1];
                int two = idx - 2 < 0 ? 0 : dp[idx - 2];
                int three = idx - 3 < 0 ? 0 : dp[idx - 3];

                if (num <= one) {
                    sb.append(1).append('+');
                    idx--;
                    continue;
                }
                num -= one;
                if (num <= two) {
                    sb.append(2).append('+');
                    idx -= 2;
                    continue;
                }
                num -= two;
                if (num <= three) {
                    sb.append(3).append('+');
                    idx -= 3;
                }
            }

            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }

        br.close();
    }
}
