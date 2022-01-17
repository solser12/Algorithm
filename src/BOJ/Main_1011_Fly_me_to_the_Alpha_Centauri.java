package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1011_Fly_me_to_the_Alpha_Centauri {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dist = -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            int num = (int) Math.sqrt(dist);

            if (dist == square(num)) {
                sb.append(num * 2 - 1).append('\n');
            } else {
                long temp = (square(num + 1) - square(num) - 1) / 2;
                if (dist <= square(num) + temp) {
                    sb.append(num * 2).append('\n');
                } else {
                    sb.append(num * 2 + 1).append('\n');
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static long square(int num) {
        return (long) num * num;
    }
}