package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179_불 {

    public static int r, c;
    public static char[][] maze;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];

        ArrayList<Loc> fire = new ArrayList<>();
        Loc start = null;
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = input.charAt(j);
                maze[i][j] = c;
                if (c == 'J') {
                    start = new Loc(i, j);
                } else if (c == 'F') {
                    fire.add(new Loc(i, j));
                }
            }
        }

        int ans = bfs(start, fire);
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
        br.close();
    }

    public static int bfs(Loc start, ArrayList<Loc> f) {

        Queue<Loc> fire = new LinkedList<>(f);
        Queue<Loc> jihoon = new LinkedList<>();
        jihoon.add(start);

        int time = 0;
        while (!jihoon.isEmpty()) {

            int size = fire.size();
            for (int s = 0; s < size; s++) {
                Loc loc = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (check(dx, dy) && (maze[dx][dy] == '.' || maze[dx][dy] == 'J')) {
                        fire.add(new Loc(dx, dy));
                        maze[dx][dy] = 'F';
                    }
                }
            }

            size = jihoon.size();
            for (int s = 0; s < size; s++) {
                Loc loc = jihoon.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (!check(dx, dy)) {
                        return time + 1;
                    } else if (maze[dx][dy] == '.') {
                        jihoon.add(new Loc(dx, dy));
                        maze[dx][dy] = 'J';
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
