package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4991_로봇청소기 {

    static char[][] map;
    static boolean[][][] visited;
    static int h, w;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static HashMap<Integer,Integer> dust = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new char[h][w];
            dust.clear();

            int x = 0, y = 0;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    map[i][j] = c;

                    if (c == 'o') {
                        x = i;
                        y = j;
                        map[i][j] = '.';
                    } else if (c == '*') {
                        dust.put(locToInt(i, j), dust.size());
                    }
                }
            }

            if (dust.size() == 0) {
                sb.append(0);
            } else {
                visited = new boolean[(1 << dust.size()) - 1][h][w];
                sb.append(bfs(x, y));
            }

            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(int x, int y) {

        int step = 1;
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y, 0));
        visited[0][x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();

                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];

                    if (dx >= 0 && dx < h && dy >= 0 && dy < w) {
                        if (!visited[loc.clear][dx][dy]) {
                            if (map[dx][dy] == '*') {
                                int idx = dust.get(locToInt(dx, dy));
                                int clear = loc.clear;
                                clear |= 1 << idx;
                                if (clear == (1 << dust.size()) - 1) return step;
                                visited[clear][dx][dy] = true;
                                q.add(new Loc(dx, dy, clear));
                            } else if (map[dx][dy] == '.') {
                                visited[loc.clear][dx][dy] = true;
                                q.add(new Loc(dx, dy, loc.clear));
                            }
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public static int locToInt(int x, int y) {
        int result = 0, mul = 1;
        result += y * mul;
        mul *= 100;
        result += x * mul;
        return result;
    }

    public static class Loc {
        int x, y, clear;

        public Loc(int x, int y, int clear) {
            this.x = x;
            this.y = y;
            this.clear = clear;
        }
    }
}