package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10464_XOR {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            int result = 0;
            if (((S % 2 == 1 ? 1 : 0) + ((F - S + (F % 2 == 1 ?  1 : 0)) / 2)) % 2 == 1) result = 1;

            int bit = 2;
            while (bit <= F) {
                int start = Math.max(bit, S);
                int sum = 0;

                if (start / bit % 2 == 1) {
                    sum += bit - (start % bit);
                }

                if (F / bit % 2 == 1) {
                    sum += (F % bit) + 1;
                }

                if (sum % 2 == 1) {
                    result |= bit;
                }

                bit <<= 1;
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
