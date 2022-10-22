package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11728_배열합치기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] ans = new int[N + M];
        int index = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[index++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ans[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(' ');
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}