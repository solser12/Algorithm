package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {

    static int R, C;
    static char[][] map;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Loc> water = new LinkedList<>();
    static Queue<Loc> hedgehog = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char data = input.charAt(j);
                map[i][j] = data;

                if (data == 'S') {
                    map[i][j] = '.';
                    hedgehog.add(new Loc(i, j));
                    visited[i][j] = true;
                } else if (data == '*') {
                    water.add(new Loc(i, j));
                }
            }
        }

        int ans = bfs();
        System.out.println(ans != -1 ? ans : "KAKTUS");

        br.close();
    }

    public static int bfs() {

        int time = 1;

        while (!hedgehog.isEmpty()) {

            // 고슴도치 이동
            int size = hedgehog.size();
            for (int s = 0; s < size; s++) {

                Loc loc = hedgehog.poll();
                if (map[loc.x][loc.y] == '*') {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];

                    if (dx >= 0 && dx < R && dy >= 0 && dy < C && !visited[dx][dy]) {
                        if (map[dx][dy] == 'D') {
                            return time;
                        } else if (map[dx][dy] == '.') {
                            visited[dx][dy] = true;
                            hedgehog.add(new Loc(dx, dy));
                        }
                    }
                }
            }

            // 물 이동
            size = water.size();
            for (int s = 0; s < size; s++) {
                Loc loc = water.poll();
                for (int d = 0; d < 4; d ++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];

                    if (dx >= 0 && dx < R && dy >= 0 && dy < C && map[dx][dy] == '.') {
                        map[dx][dy] = '*';
                        water.add(new Loc(dx, dy));
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
