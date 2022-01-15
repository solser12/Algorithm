package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2133_타일채우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 1) {
            System.out.println(0);
        } else {
            int[] dp = new int[N / 2 + 1];
            dp[0] = 1;
            dp[1] = 3;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] * 3;
                for (int j = 2; j <= i; j++) {
                    dp[i] += dp[i - j] * 2;
                }
            }
            System.out.println(dp[N / 2]);
        }

        br.close();
    }
}
