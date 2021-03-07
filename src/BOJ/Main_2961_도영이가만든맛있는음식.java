package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {

    static int N, max, ans;
    static int[][] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[2][N];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[0][i] = Integer.parseInt(st.nextToken());
            input[1][i] = Integer.parseInt(st.nextToken());
        }

        ans = 999999999;

        for (max = 1; max <= N; ++max) {
            comb(0, 0, 1);
        }

        System.out.println(ans);
        br.close();
    }

    static void comb (int cnt, int sum, int mul) {
        if (cnt == max) {
            int temp = Math.abs(sum - mul);
            ans = ans > temp ? temp : ans;
            return;
        }

        for (int i = cnt; i < N; ++i) {
            comb( i + 1, sum + input[1][i], mul * input[0][i]);
        }
    }
}
