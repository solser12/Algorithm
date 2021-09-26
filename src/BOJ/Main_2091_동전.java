package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2091_동전 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int[][] dp = new int[4][X+1];
        int[] sum = new int[X+1];
        int[] count = new int[X+1];
        int[][] coin = new int[4][2];
        for (int i = 0; i < 4; i++) {
            coin[i][1] = Integer.parseInt(st.nextToken());
        }
        coin[0][0] = 1;
        coin[1][0] = 5;
        coin[2][0] = 10;
        coin[3][0] = 25;

        for (int i = 1; i <= X; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < coin[j][0]) break;
                int idx = i - coin[j][0];

                int check = dp[j][idx] + 1;
                if (check > coin[j][1]) continue;

                int total = sum[idx] + coin[j][0];
                if (total != i) continue;

                int cnt = count[idx] + 1;

                if (count[i] < cnt) {
                    count[i] = cnt;
                    sum[i] = total;
                    for (int k = 0; k < 4; k++) {
                        if (k == j) dp[k][i] = check;
                        else dp[k][i] = dp[k][idx];
                    }
                }
            }
        }

        sb.append(dp[0][X]).append(' ').append(dp[1][X]).append(' ').append(dp[2][X]).append(' ').append(dp[3][X]);
        System.out.println(sb);
        br.close();
    }
}
