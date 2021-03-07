package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= k; i++) {
            for (int coin : list) {
                if (i - coin < 0 || dp[i - coin] == Integer.MAX_VALUE) continue;

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? "-1" : dp[k]);
        br.close();
    }
}
