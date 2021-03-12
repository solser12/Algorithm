package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {

    static int R, C, visit, ans = 0;
    static int[][] map;
    static int[][] check;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        check = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j] - 'A';
            }
        }

        visit = 1 << map[0][0];
        dfs(0, 0, 1);

        System.out.println(ans);
        br.close();
    }

    static void dfs(int x, int y, int cnt) {

        if (check[x][y] == visit) return;
        check[x][y] = visit;

        for (int d = 0; d < 4; d++) {
            int dx = x + dt[d][0];
            int dy = y + dt[d][1];
            if (dx >= 0 && dx < R && dy >= 0 && dy < C && ((visit & (1 << map[dx][dy])) == 0)) {
                visit |= 1 << map[dx][dy];
                dfs(dx, dy, cnt + 1);
                visit &= ~(1 << map[dx][dy]);
            }
        }
        ans = Math.max(ans, cnt);
    }
}
