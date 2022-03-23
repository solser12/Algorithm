package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13250_주사위게임 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] dp = new double[Math.max(N + 1, 8)];
        double sum = 6;
        for (int i = 1; i <= 7; i++) {
            dp[i] = sum / 6;
            sum += dp[i];
        }

        for (int i = 8; i <= N; i++) {
            sum -= dp[i - 7];
            dp[i] = sum / 6;
            sum += dp[i];
        }

        System.out.println(dp[N]);
        br.close();
    }
}
