package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {

    static int R, C, ans = 0;
    static char[][] map;
    static boolean[] visit = new boolean[26];
    static int[] d = {1, 0, -1, 0, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        visit[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(ans);
        br.close();
    }

    static void dfs(int x, int y, int cnt) {
        for (int i = 0; i < d.length; i+=2) {
            int dx = x + d[i];
            int dy = y + d[i+1];
            if (dx >= 0 && dx < R && dy >= 0 && dy < C && !visit[map[dx][dy] - 'A']) {
                visit[map[dx][dy] - 'A'] = true;
                dfs(dx, dy, cnt + 1);
                visit[map[dx][dy] - 'A'] = false;
            }
        }
        ans = ans < cnt ? cnt : ans;
    }
}
