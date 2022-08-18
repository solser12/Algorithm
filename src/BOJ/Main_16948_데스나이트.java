package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16948_데스나이트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(br.readLine());;
        boolean[][] visited = new boolean[r][r];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r, visited, r1, c1, r2, c2));
        br.close();
    }

    public static int bfs(int r, boolean[][] visited, int r1, int c1, int r2, int c2) {

        int[][] dt = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(r1, c1));
        visited[r1][c1] = true;
        int moveCnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                if (loc.x == r2 && loc.y == c2) {
                    return moveCnt;
                }
                for (int d = 0; d < 6; d++) {
                    int dx =loc.x + dt[d][0];
                    int dy =loc.y + dt[d][1];
                    if (check(dx, dy, r, visited)) {
                        q.offer(new Loc(dx, dy));
                        visited[dx][dy] = true;
                    }
                }
            }
            moveCnt++;
        }

        return -1;
    }

    public static boolean check(int x, int y, int r, boolean[][] visited) {
        return 0 <= x && x < r && 0 <= y && y < r && !visited[x][y];
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
