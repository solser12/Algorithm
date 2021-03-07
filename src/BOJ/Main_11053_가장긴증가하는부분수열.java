package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];
        int ans = 1;

        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        list[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (list[i] > list[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (ans < dp[i]) {
                        ans = dp[i];
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}