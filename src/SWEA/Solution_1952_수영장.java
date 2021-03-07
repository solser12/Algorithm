package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 0 ~ 2 까진 dp 때문에 사용
        int[] dp = new int[15];
        int[] charge = new int[4];

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // 요금 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                charge[i] = Integer.parseInt(st.nextToken());
            }

            // 게획 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 3; i < 15; i++) {
                int plan = Integer.parseInt(st.nextToken());
                dp[i] = Math.min(charge[0] * plan, charge[1]);
            }

            // DP
            for (int i = 3; i < 15; i++) {
                dp[i] = Math.min(dp[i] + dp[i-1], dp[i-3] + charge[2]);
            }

            dp[14] = Math.min(dp[14], charge[3]);

            sb.append('#').append(t).append(' ').append(dp[14]).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
