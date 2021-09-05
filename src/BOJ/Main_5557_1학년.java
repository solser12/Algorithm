package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[21][N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[Integer.parseInt(st.nextToken())][0]++;
        for (int i = 1; i < N - 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 20; j++) {
                if (dp[j][i-1] == 0) continue;
                int temp = j - num;
                if (temp >= 0) dp[temp][i] += dp[j][i-1];
                temp = j + num;
                if (temp <= 20) dp[temp][i] += dp[j][i-1];
            }
        }

        System.out.println(dp[Integer.parseInt(st.nextToken())][N-2]);
        br.close();
    }
}
