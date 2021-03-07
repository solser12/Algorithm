package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N;
        int[][] sticker, dp;


        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            sticker = new int [2][N];
            dp = new int[2][N+2];

            for (int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i < N+2; i++) {
                dp[0][i] = Math.max(dp[0][i-2], Math.max(dp[1][i-2], dp[1][i-1])) + sticker[0][i-2];
                dp[1][i] = Math.max(dp[1][i-2], Math.max(dp[0][i-2], dp[0][i-1])) + sticker[1][i-2];
            }

            sb.append(Math.max(dp[0][N+1], dp[1][N+1])).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
