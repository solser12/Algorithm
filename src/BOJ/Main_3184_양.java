package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3184_양 {

    public static int r, c;
    public static char[][] garden;
    public static int totalSheep = 0, totalWolves = 0;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        garden = new char[r][];
        for (int i = 0; i < r; i++) {
            garden[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (garden[i][j] != '-') {
                    bfs(i, j);
                }
            }
        }

        System.out.printf("%d %d%n", totalSheep, totalWolves);
        br.close();
    }

    public static void bfs(int x, int y) {

        int sheep = garden[x][y] == 'o' ? 1 : 0;
        int wolves = garden[x][y] == 'v' ? 1 : 0;
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        garden[x][y] = '-';

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    if (garden[dx][dy] == 'o') {
                        sheep++;
                    } else if (garden[dx][dy] == 'v') {
                        wolves++;
                    }
                    q.offer(new Loc(dx, dy));
                    garden[dx][dy] = '-';
                }
            }
        }

        if (wolves < sheep) {
            totalSheep += sheep;
        } else {
            totalWolves += wolves;
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c && garden[x][y] != '#' && garden[x][y] != '-';
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
