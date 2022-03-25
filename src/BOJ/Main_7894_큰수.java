package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7894_큰수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] digit = new int[10000001];
        double sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += Math.log10(i);
            digit[i] = (int)sum + 1;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int m = Integer.parseInt(br.readLine());
            sb.append(digit[m]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
