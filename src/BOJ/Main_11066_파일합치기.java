package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066_파일합치기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] data = new int[K];
            int[][] dp = new int[K][K];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < K; i++) {
                for (int j = 0; j < K; j++) {
                    int end = i + j;
                    if (end >= K) break;
                    dp[j][end] = Math.min(dp[j][end-1], dp[j+1][end]);
                    for (int k = j; k <= end; k++) {
                        dp[j][end] += data[k];
                    }
                }
            }

            for (int[] a : dp) {
                for (int b : a) {

                    System.out.print(b + "\t");
                }
                System.out.println();
            }
            sb.append(dp[0][K-1]).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
