package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3187_양치기꿍 {

    public static int r, c;
    public static char[][] fence;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int sheepCnt = 0, wolfCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        fence = new char[r][];
        for (int i = 0; i < r; i++) {
            fence[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (fence[i][j] != '#') {
                    bfs(i , j);
                }
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
        br.close();
    }

    public static void bfs(int x, int y) {

        int sheep = 0, wolf = 0;

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        if (fence[x][y] == 'v') {
            wolf++;
        } else if (fence[x][y] == 'k') {
            sheep++;
        }
        fence[x][y] = '#';

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    if (fence[dx][dy] == 'v') {
                        wolf++;
                    } else if (fence[dx][dy] == 'k') {
                        sheep++;
                    }
                    q.offer(new Loc(dx, dy));
                    fence[dx][dy] = '#';
                }
            }
        }

        if (sheep > wolf) {
            sheepCnt += sheep;
        } else {
            wolfCnt += wolf;
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c && fence[x][y] != '#';
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
