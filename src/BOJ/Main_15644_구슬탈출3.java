package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15644_구슬탈출3 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int redX, redY, blueX, blueY;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[] cway = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        Loc blue = null, red = null;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                board[i][j] = c;
                if (c == 'B') {
                    blue = new Loc(i, j);
                    board[i][j] = '.';
                } else if (c == 'R') {
                    red = new Loc(i, j);
                    board[i][j] = '.';
                }
            }
        }

        bfs(blue, red);

        br.close();
    }

    public static void bfs(Loc b, Loc r) {

        Queue<Bead> q = new LinkedList<>();
        q.add(new Bead(b, r, ""));
        visited[b.x][b.y][r.x][r.y] = true;

        int time = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Bead bead = q.poll();
                for (int i = 0; i < 4; i++) {
                    Bead result = bead.rotate(i);
                    if (result == null) continue;
                    if (result.red.x == -1) {
                        System.out.println(time);
                        System.out.println(result.log);
                        return;
                    }

                    q.add(result);
                }
            }

            time++;

            if (time > 10) break;
        }

        System.out.println(-1);
    }

    public static class Bead {
        Loc blue, red;
        String log;

        public Bead(Loc blue, Loc red, String log) {
            this.blue = blue;
            this.red = red;
            this.log = log;
        }

        public Bead rotate(int way) {

            boolean first;

            // 누가 먼저 이동해야되는지 확인
            first = findFirst(way);
            redX = this.red.x;
            redY = this.red.y;
            blueX = this.blue.x;
            blueY = this.blue.y;

            if (first) {
                while (board[redX][redY] == '.') {
                    redX += dt[way][0];
                    redY += dt[way][1];
                }

                if (board[redX][redY] == 'O') {
                    redX = -1; redY = -1;
                } else if (board[redX][redY] == '#') {
                    redX -= dt[way][0];
                    redY -= dt[way][1];
                }
            } else {
                while (board[blueX][blueY] == '.') {
                    blueX += dt[way][0];
                    blueY += dt[way][1];
                }

                // Blue가 구멍에 빠지면
                if (board[blueX][blueY] == 'O') {
                    return null;
                } else if (board[blueX][blueY] == '#') {
                    blueX -= dt[way][0];
                    blueY -= dt[way][1];
                }
            }

            if (first) {
                while (board[blueX][blueY] == '.' && !(redX == blueX && redY == blueY)) {
                    blueX += dt[way][0];
                    blueY += dt[way][1];
                }

                if (board[blueX][blueY] == 'O') {
                    return null;
                } else {
                    blueX -= dt[way][0];
                    blueY -= dt[way][1];
                }
            } else {
                while (board[redX][redY] == '.' && !(redX == blueX && redY == blueY)) {
                    redX += dt[way][0];
                    redY += dt[way][1];
                }

                if (board[redX][redY] == 'O') {
                    redX = -1;
                    redY = -1;
                } else {
                    redX -= dt[way][0];
                    redY -= dt[way][1];
                }
            }

            if (redX >= 0) {
                if (visited[blueX][blueY][redX][redY]) {
                    return null;
                }

                visited[blueX][blueY][redX][redY] = true;
            }

            return new Bead(new Loc(blueX, blueY), new Loc(redX, redY), log + cway[way]);
        }


        public boolean findFirst(int way) {

            // true 면 Red가 먼저 false 면 Blue가 먼저
            boolean result;

            if (way == 0) {
                if (this.blue.x >= this.red.x) result = true;
                else result = false;
            } else if (way == 1) {
                if (this.blue.x < this.red.x) result = true;
                else result = false;
            } else if (way == 2) {
                if (this.blue.y >= this.red.y) result = true;
                else result = false;
            } else {
                if (this.blue.y < this.red.y) result = true;
                else result = false;
            }

            return result;
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
