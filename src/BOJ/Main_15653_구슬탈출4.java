package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15653_구슬탈출4 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<Status> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (c == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                } else {
                    board[i][j] = c;
                }
            }
        }

        bfs(rx, ry, bx, by);

        br.close();
    }

    public static void bfs(int rx, int ry, int bx, int by) {

        q.add(new Status(new Loc(rx, ry), new Loc(bx, by)));
        visited[rx][ry][bx][by] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Status status = q.poll();

                if (status.red == null) {
                    System.out.println(time);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    turn(i, status);
                }
            }

            time++;
        }

        System.out.println(-1);
    }

    public static void turn(int type, Status status) {

        // 0 : 상관없음 1 : 빨강 2 : 파랑
        int first = findFirst(type, status);

        Loc red, blue;
        if (first == 0) {
            blue = move(type, status.blue.x, status.blue.y);
            if (blue == null) return;
            red = move(type, status.red.x, status.red.y);
        } else if (first == 1) {
            red = move(type, status.red.x, status.red.y);
            if (red != null) board[red.x][red.y] = '#';
            blue = move(type, status.blue.x, status.blue.y);
            if (red != null) board[red.x][red.y] = '.';
            if (blue == null) return;
        } else {
            blue = move(type, status.blue.x, status.blue.y);
            if (blue == null) return;
            board[blue.x][blue.y] = '#';
            red = move(type, status.red.x, status.red.y);
            board[blue.x][blue.y] = '.';
        }

        if (red != null) {
            if (visited[red.x][red.y][blue.x][blue.y]) return;
            else visited[red.x][red.y][blue.x][blue.y] = true;
        }
        q.add(new Status(red, blue));

    }

    public static Loc move(int type, int x, int y) {
        int dx = x, dy = y;

        while (board[dx][dy] != '#') {
            dx += dt[type][0];
            dy += dt[type][1];

            if (board[dx][dy] == 'O') {
                return null;
            }
        }

        dx -= dt[type][0];
        dy -= dt[type][1];

        return new Loc(dx, dy);
    }

    public static int findFirst(int type, Status status) {

        int result = 0;

        switch (type) {
            case 0:
                if (status.red.y == status.blue.y) {
                    result = status.red.x <= status.blue.x ? 1 : 2;
                }
                break;
            case 1:
                if (status.red.y == status.blue.y) {
                    result = status.red.x > status.blue.x ? 1 : 2;
                }
                break;
            case 2:
                if (status.red.x == status.blue.x) {
                    result = status.red.y <= status.blue.y ? 1 : 2;
                }
                break;
            case 3:
                if (status.red.x == status.blue.x) {
                    result = status.red.y > status.blue.y ? 1: 2;
                }
                break;
        }

        return result;
    }

    public static class Status {
        Loc red, blue;

        public Status(Loc red, Loc blue) {
            this.red = red;
            this.blue = blue;
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
