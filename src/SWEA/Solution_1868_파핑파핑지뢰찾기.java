package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기 {

    static int N, cnt, ans;
    static int[][] map;
    static boolean[][] view;
    static int[][] dir = {{-1, 0, 1, 0, -1, 1, 1, -1}, {0, 1, 0, -1, 1, 1, -1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            view = new boolean[N][N];
            cnt = N * N;
            ans = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    char temp = input.charAt(j);
                    if (temp == '*') {
                        view[i][j] = true;
                        map[i][j] = -1;
                        cnt--;
                        for (int d = 0; d < 8; d++) {
                            int dx = i + dir[0][d];
                            int dy = j + dir[1][d];
                            if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] != -1) {
                                map[dx][dy]++;
                            }
                        }
                    }
                }
            }

            System.out.println(cnt);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 && !view[i][j]) {
                        show(i, j);
                        ans++;
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(ans + cnt).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void show(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        view[x][y] = true;
        cnt--;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for(int d = 0; d < 8; d++) {
                int dx = loc.x + dir[0][d];
                int dy = loc.y + dir[1][d];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N  && !view[dx][dy]) {
                    if (map[dx][dy] == 0) {
                        q.add(new Loc(dx, dy));
                    }
                    view[dx][dy] = true;
                    cnt--;
                }
            }
        }
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
