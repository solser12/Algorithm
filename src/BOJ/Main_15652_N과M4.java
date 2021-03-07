package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_15652_N과M4 {

    static int N, M, len = 0;
    static int[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[M];

        for (int i = 0; i < N; ++i) {
            list[len++] = i + 1;
            perm(i, 1);
            len--;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void perm(int start, int cnt) {

        if (cnt == M) {
            for (int i = 0; i < list.length; ++i) {
                sb.append(list[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; ++i) {
            list[len++] = i + 1;
            perm(i,cnt + 1);
            len--;
        }
    }
}
