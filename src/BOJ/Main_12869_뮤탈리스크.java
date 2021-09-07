package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크 {

    static int N;
    static int[] scv = new int[3];
    static int[][][] dp = new int[61][61][61];
    static int[][] damage = {{1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 3, 1}, {9, 1, 3}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        scv = new int[3];
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scv);

        System.out.println(attack(scv[0], scv[1], scv[2]));
        br.close();
    }

    public static int attack(int a, int b, int c) {

        if (a == 0 && b == 0 && c == 0) return 0;

        if (dp[a][b][c] != 0) return dp[a][b][c];

        int cnt = Integer.MAX_VALUE;
        for (int d = 0; d < 6; d++) {
            scv[0] = Math.max(a - damage[d][0], 0);
            scv[1] = Math.max(b - damage[d][1], 0);
            scv[2] = Math.max(c - damage[d][2], 0);
            Arrays.sort(scv);
            cnt = Math.min(cnt, attack(scv[0], scv[1], scv[2]) + 1);
        }

        dp[a][b][c] = cnt;
        return cnt;
    }
}
