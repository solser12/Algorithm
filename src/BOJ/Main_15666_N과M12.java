package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15666_N과M12 {

    static int N, M, len = 0;
    static int[] list, print;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        print = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        perm(0, 0);

        System.out.print(sb);
        br.close();
    }

    static void perm(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < print.length; ++i) sb.append(print[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; ++i) {
            if (i == 0 || list[i] > list[i-1]) {
                print[len++] = list[i];
                perm(i, cnt + 1);
                len--;
            }
        }
    }
}
