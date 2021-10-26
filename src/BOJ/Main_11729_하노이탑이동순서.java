package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11729_하노이탑이동순서 {

    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);

        System.out.println(cnt + "\n" + sb.toString());
        br.close();
    }

    public static void hanoi(int depth, int start, int end, int mid) {

        if (depth == 1) {
            cnt++;
            sb.append(start).append(' ').append(end).append('\n');
            return;
        }

        hanoi(depth - 1, start, mid, end);
        sb.append(start).append(' ').append(end).append('\n');
        cnt++;
        hanoi(depth - 1, mid, end, start);
    }
}
