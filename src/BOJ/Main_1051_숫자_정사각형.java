package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자_정사각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] rectangle = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                rectangle[i][j] = input.charAt(j) - '0';
            }
        }

        int len = Math.min(n, m);
        for (int i = len; i >= 1; i--) {
            if (check(n, m, rectangle, i - 1)) {
                System.out.println(i * i);
                break;
            }
        }

        br.close();
    }

    public static boolean check(int n, int m, int[][] rectangle, int len) {
        for (int x = 0; x < n - len; x++) {
            for (int y = 0; y < m - len; y++) {
                if (rectangle[x][y] == rectangle[x][y + len] && rectangle[x][y + len] == rectangle[x + len][y + len]
                        && rectangle[x][y] == rectangle[x + len][y]) {
                    return true;
                }
            }
        }
        return false;
    }
}
