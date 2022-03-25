package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7894_큰수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int m = Integer.parseInt(br.readLine());

            double sum = 0;
            for (int i = 2; i <= m; i++) {
                sum += Math.log10(i);
            }
            sb.append((int)sum + 1).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
