package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14002_가장긴증가하는부분수열4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int[] dp = new int[N];
        int ans = 1;
        int idx = 0;

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
                        idx = i;
                        break;
                    }
                }
            }
        }

        int[] ans_list = new int[ans];
        ans_list[0] = list[idx--];
        int num = ans - 1;

        for (int i = 1; i < ans; i++) {
            for (int j = idx; j >= 0; j--) {
                if (ans_list[i-1] > list[j] && dp[j] == num) {
                    ans_list[i] = list[j];
                    idx = j - 1;
                    num--;
                    break;
                }
            }
        }

        sb.append(ans).append('\n');
        for (int i = ans-1; i >= 0; i--) {
            sb.append(ans_list[i]).append(' ');
        }

        System.out.println(sb.toString());
        br.close();
    }
}