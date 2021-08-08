package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10836_여왕벌 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] sum = new int[M * 2 - 1];
        Arrays.fill(sum, 1);

        for (int i = 0; i < N; i++) {
            int a, b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M * 2 - 1; j++) {

                if (a == 0) {
                    if (b == 0) {
                        sum[j] += 2;
                    }
                    else {
                        sum[j]++;
                        b--;
                    }
                } else {
                    a--;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            sb.append(sum[M - i - 1]).append(' ');
            for (int j = M; j < M * 2 - 1; j++) {
                sb.append(sum[j]).append(' ');
            }
            sb.append('\n');
        }


        System.out.println(sb);
        br.close();
    }
}
