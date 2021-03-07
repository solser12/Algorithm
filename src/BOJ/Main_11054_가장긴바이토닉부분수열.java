package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11054_가장긴바이토닉부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int [N];
        int[] dp = new int[N];
        int[] rdp = new int[N];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        rdp[N-1] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            rdp[N-1-i] = 1;
            for (int j = i-1; j>= 0; j--) {
                if (list[i] > list[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
                if (list[N-1-i] > list[N-1-j] && rdp[N-1-i] < rdp[N-1-j] + 1) rdp[N-1-i] = rdp[N-1-j] + 1;
            }
        }

        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp = dp[i] + rdp[i] - 1;
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
        br.close();
    }
}
