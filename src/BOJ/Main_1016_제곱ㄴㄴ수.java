package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1016_제곱ㄴㄴ수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[(int) (max - min + 1)];

        for (int i = 2; i <= Math.sqrt(max); i++) {
            long num = (long) i * i;
            for (long j = min / num + (min % num == 0 ? 0 : 1); j * num <= max; j++) {
                check[(int) (j * num - min)] = true;
            }
        }

        int ans = 0;
        for (boolean b : check) {
            if (!b) ans++;
        }

        System.out.println(ans);
        br.close();
    }
}
