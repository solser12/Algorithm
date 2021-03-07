package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int dp[] = new int[L+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kal = Integer.parseInt(st.nextToken());
                for (int j = L; j >= kal; j--) {
                    dp[j] = Math.max(dp[j-kal] + score, dp[j]);
                }
            }
            sb.append('#').append(t).append(' ').append(dp[L]).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}
