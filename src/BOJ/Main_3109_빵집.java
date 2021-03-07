package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

    static int R, C;
    static char[][] map;
    static int cnt = 0;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            flag = false;
            dfs(i, 0);
        }

        System.out.println(cnt);
        br.close();
    }

    static void dfs(int x, int y) {

        if (x < 0 || x >= R || map[x][y] == 'x') return;
        map[x][y] = 'x';

        if (y == C - 1) {
            cnt++;
            flag = true;
            return;
        }

        dfs(x-1, y+1);
        if (flag) return;
        dfs(x, y+1);
        if (flag) return;
        dfs(x+1, y+1);
        if (flag) return;
    }
}
