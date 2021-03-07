package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            int max = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = 1;
                for (int j = i-1; j >= 0; j--) {
                    if (dp[i] <= dp[j] && arr[i] > arr[j]) {
                        dp[i] = dp[j] + 1;
                        if (max < dp[i]) {
                            max = dp[i];
                            break;
                        }
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(max).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}
