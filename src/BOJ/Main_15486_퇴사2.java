package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15486_퇴사2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            max = Math.max(max, dp[i]);

            if (i + day <= N) dp[i+day] = Math.max(dp[i+day], max + pay);
        }

        System.out.println(Math.max(dp[N], max));
        br.close();
    }
}
