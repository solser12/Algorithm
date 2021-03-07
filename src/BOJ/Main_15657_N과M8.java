package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8 {

    static int N, M, len = 0;
    static int[] list, print;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        for (int i = 0; i < N; ++i) {
            print[len++] = list[i];
            perm(i, 1);
            len--;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void perm(int start, int cnt) {

        if (cnt == M) {
            for (int i = 0; i < print.length; ++i) {
                sb.append(print[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; ++i) {
            print[len++] = list[i];
            perm(i, cnt + 1);
            len--;
        }
    }
}
