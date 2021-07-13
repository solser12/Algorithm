package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661_좋은수열 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        find(0);

        br.close();
    }

    static void find(int cnt) {

        if (cnt == N) {
            System.out.println(sb);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {

            sb.append(i);

            if (check()) {
                sb.setLength(sb.length() - 1);
                continue;
            }

            find(cnt + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    static boolean check() {

        for (int i = 0; i < sb.length() / 2; i++) {
            int loc = sb.length() - (1 + i);
            if (sb.substring(loc).equals(sb.substring(loc - i - 1, loc))) {
                return true;
            }
        }

        return false;
    }
}
