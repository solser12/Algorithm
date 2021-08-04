package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7490_0만들기 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder temp = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            temp.setLength(0);
            recu(1, false, true, 0);
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void recu(int depth, boolean isSpace, boolean type, int sum) {

        if (depth == N + 1) {
            if (sum == 0) {
                sb.append(temp.substring(1)).append('\n');
            }
            return;
        }

        if (isSpace) {
            int num = ((depth - 1) * 10 + depth) * (type ? 1 : -1);
            temp.append(' ').append(depth);
            recu(depth + 1, false, type, sum + num);
            temp.setLength(temp.length() - 2);
        }

        if (!isSpace) {
            temp.append('+').append(depth);
            if (depth != N) {
                recu(depth + 1, true, true, sum);
            }
            recu(depth + 1, false, true, sum + depth);
            temp.setLength(temp.length() - 2);

            temp.append('-').append(depth);
            if (depth != N && depth != 1) {
                recu(depth + 1, true, false, sum);
            }
            if (depth != 1) {
                recu(depth + 1, false, false, sum - depth);
            }
            temp.setLength(temp.length() - 2);
        }
    }
}
