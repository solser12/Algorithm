package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발DP {

    public static void main(String[] args) throws IOException {

        //DP

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] blist = new int[ N];
            int[] wlist = new int[N];
            int[] rlist = new int[N];
            int[][] dp = new int[N][3];

            for (int n = 0; n < N; n++) {
                char[] input = br.readLine().toCharArray();
                for (int i = 0; i < M; i++) {
                    if (input[i] == 'W') { rlist[n]++; blist[n]++; }
                    else if (input[i] =='B') { wlist[n]++; rlist[n]++; }
                    else if (input[i] == 'R') { wlist[n]++; blist[n]++; }
                }
            }

            dp[0][0] = wlist[0];
            dp[1][0] = dp[0][0] + wlist[1];
            dp[1][1] = dp[0][0] + blist[1];
            dp[1][2] = Integer.MAX_VALUE;

            for (int i = 2; i < N; i++) {
                dp[i][0] = dp[i-1][0] + wlist[i];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + blist[i];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + rlist[i];
            }

            sb.append('#').append(t).append(' ').append(dp[N-1][2]).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}