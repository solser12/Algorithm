package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16724_피리부는사나이 {

    static int N, M, ans = 0;
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], 0);

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(i, j);
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void find(int x, int y) {

        if (visited[x][y] > 1) {
            return;
        } else if (visited[x][y] == 1) {
            ans++;
            return;
        }

        visited[x][y] = 1;
        Loc loc = way(map[x][y], x, y);
        find(loc.x, loc.y);
        visited[x][y] = 2;
    }

    public static Loc way(char c, int x, int y) {
        int dx, dy;
        if (c == 'U') {
            dx = x - 1;
            dy = y;
        } else if (c == 'D') {
            dx = x + 1;
            dy = y;
        } else if (c == 'L') {
            dx = x;
            dy = y - 1;
        } else {
            dx = x;
            dy = y + 1;
        }

        return new Loc(dx, dy);
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
