package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11812_K진트리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        if (K == 1) {
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                long a = Long.parseLong(st.nextToken());
                long b = Long.parseLong(st.nextToken());
                sb.append(Math.abs(a - b)).append('\n');
            }
        } else {
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                long a = Long.parseLong(st.nextToken()) - 1;
                long b = Long.parseLong(st.nextToken()) - 1;
                int cnt = 0;
                while (a != b) {
                    if (a > b) {
                        a = (a - 1) / K;
                    } else {
                        b = (b - 1) / K;
                    }
                    cnt++;
                }
                sb.append(cnt).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }
}
