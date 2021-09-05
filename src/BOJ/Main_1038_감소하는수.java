package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1038_감소하는수 {

    static int N, d, cnt;
    static boolean isFind = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {0, 9, 45, 120, 210, 252, 210, 120, 45, 10, 1};

        N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
        } else {
            d = 2;
            cnt = 9;
            for (; d <= 10; d++) {
                cnt += arr[d];
                if (cnt >= N) {
                    cnt -= arr[d];
                    break;
                }
            }
            if (d > 10) System.out.println(-1);
            else find(0, 10);
        }

        br.close();
    }

    public static void find(int depth, int num) {

        if (isFind) return;

        if (depth == d) {
            cnt++;
            if (cnt == N) {
                System.out.println(sb);
                isFind = true;
            }
            return;
        }

        for (int i = 0; i < num; i++) {
            if (depth == 0 && i == 0) continue;
            sb.append(i);
            find(depth + 1, i);
            sb.setLength(sb.length()-1);
        }
    }
}
