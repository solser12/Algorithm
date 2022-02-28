package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830_행렬제곱 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] table = new int[N][N];
        int[][] ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
            ans[i][i] = 1;
        }

        while (B > 0) {
            if (B % 2 == 1) ans = calc(N, ans, table);
            table = calc(N, table, table);
            B /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] i : ans) {
            for (int j : i) {
                sb.append(j).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int[][] calc(int N, int[][] a, int[][] b) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                }
                temp[i][j] %= 1000;
            }
        }

        return temp;
    }
}