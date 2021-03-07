package BOJ;

import java.io.*;

public class Main_9095_123더하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] memo = new int[N+1];

            for (int i = 1; i <= N; i++) {
                if (i == 1) memo[i] = 1;
                else if (i == 2) memo[i] = 2;
                else if (i == 3) memo[i] = 4;
                else {
                    memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
                }
            }

            sb.append(memo[N]).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
