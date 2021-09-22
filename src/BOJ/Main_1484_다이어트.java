package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1484_다이어트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] square = new long[50001];
        square[1] = 1;
        square[2] = 4;

        int G = Integer.parseInt(br.readLine());

        int left = 1, right = 2;
        while (true) {
            long temp = square[right] - square[left];

            if (temp > G) {
                left++;
            } else {
                if (temp == G) {
                    sb.append(right).append('\n');
                }
                right++;
                long sq = (long) right * right;
                if (sq - square[right-1] > G) break;
                square[right] = sq;
            }
        }

        if (sb.length() == 0) sb.append(-1);

        System.out.println(sb);
        br.close();
    }
}
