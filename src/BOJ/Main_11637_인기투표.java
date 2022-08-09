package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11637_인기투표 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0, num = 0, max = 0, sameCnt = 0;
            for (int i = 1; i <= n; i++) {
                int count = Integer.parseInt(br.readLine());
                if (max < count) {
                    sum += (max * sameCnt);
                    sameCnt = 1;
                    max = count;
                    num = i;
                } else if (max > count) {
                    sum += count;
                } else {
                    sameCnt++;
                }
            }

            if (sameCnt > 1) {
                sb.append("no winner\n");
            } else if (sum < max) {
                sb.append("majority winner ").append(num).append('\n');
            } else {
                sb.append("minority winner ").append(num).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }
}