package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

    static int[] list;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new int[N];
            ans = -1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            search();
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void search() {

    }
}
