package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3197_백조의호수 {

    static int R, C;
    static Loc start, end;
    static char[][] lake;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited, swanVisited;
    static Queue<Loc> ice = new LinkedList<>();
    static Queue<Loc> swan = new LinkedList<>();
    static Queue<Loc> temp = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        visited = new boolean[R][C];
        swanVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);

                if (c == 'L') {
                    if (start == null) start = new Loc(i, j);
                    else end = new Loc(i, j);
                    lake[i][j] = '.';
                    continue;
                }
                lake[i][j] = c;
            }
        }

        make();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j] == '.' && !visited[i][j]) {
                    make(i, j);
                }
            }
        }

        int ans = 1;
        while (!meeting()) {
            melting();
            ans++;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean meeting() {
        temp.clear();
        while (!swan.isEmpty()) {
            Loc loc = swan.poll();
            if (loc.x == end.x && loc.y == end.y) {
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy) && !swanVisited[dx][dy]) {
                    swanVisited[dx][dy] = true;
                    if (lake[dx][dy] == '.') {
                        swan.offer(new Loc(dx, dy));
                    } else {
                        temp.offer(new Loc(dx, dy));
                    }
                }
            }
        }

        Queue<Loc> t = swan;
        swan = temp;
        temp = t;
        return false;
    }

    public static void melting() {
        int size = ice.size();
        for (int s = 0; s < size; s++) {
            Loc loc = ice.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    lake[dx][dy] = '.';
                    ice.offer(new Loc(dx, dy));
                }
            }
        }
    }

    public static void make() {
        temp.clear();
        temp.offer(new Loc(start.x, start.y));
        swanVisited[start.x][start.y] = true;

        while (!temp.isEmpty()) {
            Loc loc = temp.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy) && !swanVisited[dx][dy]) {
                    swanVisited[dx][dy] = true;
                    if (lake[dx][dy] == '.') {
                        temp.offer(new Loc(dx, dy));
                    } else {
                        swan.offer(new Loc(dx, dy));
                    }
                }
            }
        }
    }

    public static void make(int x, int y) {
        temp.clear();
        temp.offer(new Loc(x, y));
        visited[x][y] = true;

        while (!temp.isEmpty()) {
            Loc loc = temp.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if (lake[dx][dy] == '.') {
                        temp.offer(new Loc(dx, dy));
                    } else {
                        lake[dx][dy] = '.';
                        ice.offer(new Loc(dx, dy));
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        if (x >= 0 && x < R && y >= 0 && y < C) return true;
        return false;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
