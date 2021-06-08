package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {

    static int N;
    static char[][] picture;
    static boolean[][] normal, blind;
    static int nAns = 0, bAns = 0;
    static Queue<Loc> q = new LinkedList<>();
    static int[][] dt = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][];

        normal = new boolean[N][N];
        blind = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            picture[i] = input.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!normal[i][j]) {
                    normalBfs(i, j);
                    nAns++;
                }

                if (!blind[i][j]) {
                    blindBfs(i, j);
                    bAns++;
                }
            }
        }

        System.out.println(nAns + " " + bAns);
        br.close();
    }

    public static void blindBfs(int x, int y) {
        char color = picture[x][y];
        if (color == 'G') color = 'R';

        q.clear();
        q.add(new Loc(x, y));
        blind[x][y] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if (dx < 0 || dx >= N || dy < 0 || dy >= N || blind[dx][dy]) {
                    continue;
                } else if (color != picture[dx][dy]) {
                    if (color != 'R' || picture[dx][dy] != 'G') {
                        continue;
                    }
                }

                q.add(new Loc(dx, dy));
                blind[dx][dy] = true;
            }
        }
    }

    public static void normalBfs(int x, int y) {
        char color = picture[x][y];

        q.clear();
        q.add(new Loc(x, y));
        normal[x][y] = true;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx < 0 || dx >= N || dy < 0 || dy >= N || normal[dx][dy] || color != picture[dx][dy]) {
                    continue;
                }
                q.add(new Loc(dx, dy));
                normal[dx][dy] = true;
            }
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
