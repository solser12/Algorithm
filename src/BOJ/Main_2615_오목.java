package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615_오목 {

    static int[][] board = new int[19][19];
    static int[] d = {0, 1, 1, 1, 1, 0, -1, 1};
    static int[] rd = {0, -1, -1, -1, -1, 0, 1, -1};
    static int borw, fin = 0;
    static int[] loc = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    if (Check(i, j)) {
                        fin = borw;
                        i = 20;
                        break;
                    }
                }
            }
        }

        sb.append(fin).append('\n');
        if (fin != 0) sb.append(loc[0] + 1).append(' ').append(loc[1] + 1).append('\n');

        System.out.println(sb.toString());
        br.close();
    }

    static boolean Check(int x, int y) {
        borw = board[x][y] == 1 ? 1 : 2;
        int dx, dy;
        // 4방향 체크
        for (int i = 0; i < d.length; i += 2) {
            int rx = x + rd[i];
            int ry = y + rd[i + 1];
            if (rx >= 0 && rx < 19 && ry >= 0 && ry < 19) {
                if (board[rx][ry] == borw) continue;
            }
            dx = x;
            dy = y;
            int cnt = 0;
            while (true) {
                if (dx < 0 || dx >= 19 || dy < 0 || dy >= 19 || board[dx][dy] != borw) {
                    dx -= d[i];
                    dy -= d[i + 1];
                    break;
                }
                dx += d[i];
                dy += d[i + 1];
                cnt++;
            }

            if (cnt == 5) {
                loc[0] = x;
                loc[1] = y;
                return true;
            }
        }
        return false;
    }
}