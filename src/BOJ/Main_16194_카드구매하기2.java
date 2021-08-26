package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16194_카드구매하기2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int left = 0, right = i - 1;
            dp[i] = Integer.parseInt(st.nextToken());
            while (left <= right) {
                dp[i] = Math.min(dp[i], dp[left] + dp[right]);
                left++;
                right--;
            }
        }

        System.out.println(dp[N-1]);
        br.close();
    }
}
