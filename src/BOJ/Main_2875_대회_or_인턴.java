package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2875_대회_or_인턴 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt, rest;
        if (M * 2 < N) {
            cnt = M;
            rest = N - (M * 2);
        } else {
            cnt = N / 2;
            rest = M - (N / 2) + (N % 2);
        }
        K -= rest;

        if (K > 0) {
            cnt -= 1 + ((K - 1) / 3);
        }

        System.out.println(Math.max(0, cnt));
        br.close();
    }
}