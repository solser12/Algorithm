package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7570_줄세우기 {

    public static void main(String[] args) throws IOException {

        final int NULL = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] index = new int[N + 1];
        Arrays.fill(index, NULL);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            index[num] = i;
            if (index[num - 1] != NULL) {
                dp[i] = dp[index[num - 1]] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(N - ans);
        br.close();
    }
}