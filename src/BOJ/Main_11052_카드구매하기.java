package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11052_카드구매하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int price = Integer.parseInt(st.nextToken());
            card[i] = price;
        }
        Arrays.fill(dp, 0);

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j > 0; j--) {
                int temp = dp[i - j] + card[j];
                dp[i] = Math.max(dp[i], temp);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
