package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2469_사다리타기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] want = br.readLine().toCharArray();
        Ladder[][] ladders = new Ladder[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                ladders[i][j] = new Ladder();
            }
        }

        int findLine = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.charAt(0) == '?') {
                findLine = i;
                continue;
            }

            for (int j = 0; j < k - 1; j++) {
                if (input.charAt(j) == '-') {
                    ladders[i][j].right = true;
                    ladders[i][j + 1].left = true;
                }
            }
        }

        char[] topDown = new char[k];
        for (int i = 0; i < k; i++) {
            int loc = i;
            for (int j = 0; j < findLine; j++) {
                loc += ladders[j][loc].move();
            }
            topDown[loc] = (char) ('A' + i);
        }

        char[] bottomUp = want.clone();
        for (int i = 0; i < k; i++) {
            int loc = i;
            for (int j = n - 1; j > findLine; j--) {
                loc += ladders[j][loc].move();
            }
            bottomUp[loc] = want[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if (topDown[i] == bottomUp[i]) {
                sb.append('*');
            } else {
                if (topDown[i] == bottomUp[i + 1] && topDown[i + 1] == bottomUp[i]) {
                    sb.append("-");
                    if (i < k - 2) sb.append("*");
                    i++;
                } else {
                    sb.setLength(0);
                    sb.append("x".repeat(k - 1));
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Ladder {
        boolean left = false, right = false;

        public int move() {
            if (left) return -1;
            else if (right) return 1;
            return 0;
        }
    }
}
