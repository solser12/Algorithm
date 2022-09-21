package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18405_경쟁적전염 {

    public static int n, k, s;
    public static int[][] tube;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static Queue<Loc>[] q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tube = new int[n][n];
        q = new Queue[k + 1];
        for (int i = 1; i <= k; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                if (tube[i][j] > 0) {
                    q[tube[i][j]].offer(new Loc(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        bfs();

        System.out.println(tube[x][y]);
        br.close();
    }

    public static void bfs() {
        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= k; j++) {
                int size = q[j].size();
                for (int l = 0; l < size; l++) {
                    Loc loc = q[j].poll();
                    for (int d = 0; d < 4; d++) {
                        int dx = loc.x + dt[d][0];
                        int dy = loc.y + dt[d][1];
                        if (check(dx, dy)) {
                            q[j].offer(new Loc(dx, dy));
                            tube[dx][dy] = j;
                        }
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n && tube[x][y] == 0;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
