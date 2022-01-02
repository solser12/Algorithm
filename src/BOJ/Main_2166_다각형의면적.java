package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2166_다각형의면적 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[2][N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Long.parseLong(st.nextToken());
            arr[1][i] = Long.parseLong(st.nextToken());
        }
        arr[0][N] = arr[0][0];
        arr[1][N] = arr[1][0];

        long temp1 = 0, temp2 = 0;
        for (int i = 0; i < N; i++) {
            temp1 += arr[0][i] * arr[1][i + 1];
            temp2 += arr[0][i + 1] * arr[1][i];
        }
        double ans = Math.abs(temp1 - temp2) / 2.0;

        System.out.printf("%.1f%n", ans);
        br.close();
    }
}
