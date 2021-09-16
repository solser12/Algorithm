package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16197_두동전 {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        ArrayList<Loc> coins = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == 'o') {
                    coins.add(new Loc(i, j));
                } else {
                    board[i][j] = c;
                }
            }
        }

        System.out.println(bfs(coins.get(0), coins.get(1)));
        br.close();
    }

    public static int bfs(Loc l1, Loc l2) {

        Queue<Now> q = new LinkedList<>();
        q.offer(new Now(l1, l2));
        visited[l1.x][l1.y][l2.x][l2.y] = true;
        visited[l2.x][l2.y][l1.x][l1.y] = true;

        int move = 0;
        while (!q.isEmpty() && move <= 10) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Now now = q.poll();

                if (now.loc1.x == -1 || now.loc2.x == -1) {
                    return move;
                }

                for (int d = 0; d < 4; d++) {
                    Now temp = now.move(d);
                    if (temp == null) continue;
                    q.add(temp);
                }
            }
            move++;
        }

        return -1;
    }

    public static class Now {
        Loc loc1, loc2;

        public Now(Loc loc1, Loc loc2) {
            this.loc1 = loc1;
            this.loc2 = loc2;
        }

        public Now move(int d) {
            Loc first, last, newLoc1, newLoc2;

            if (first(d)) {
                first = loc1;
                last = loc2;
            } else {
                first = loc2;
                last = loc1;
            }

            int dx1 = first.x + dt[d][0];
            int dy1 = first.y + dt[d][1];
            if (dx1 < 0 || dx1 >= N || dy1 < 0 || dy1 >= M) {
                dx1 = -1;
                newLoc1 = new Loc(dx1, dy1);
            } else {
               if (board[dx1][dy1] == '#') {
                   dx1 = first.x;
                   dy1 = first.y;
               }
               newLoc1 = new Loc(dx1, dy1);
            }

            int dx2 = last.x + dt[d][0];
            int dy2 = last.y + dt[d][1];
            if (dx2 < 0 || dx2 >= N || dy2 < 0 || dy2 >= M) {
                if (dx1 == -1) return null;
                dx2 = -1;
                newLoc2 = new Loc(dx2, dy2);
                return new Now(newLoc1, newLoc2);
            } else {
                if (board[dx2][dy2] == '#' || (dx1 == dx2 && dy1 == dy2)) {
                    dx2 = last.x;
                    dy2 = last.y;
                }
                newLoc2 = new Loc(dx2, dy2);
                if (dx1 == -1) return new Now(newLoc1, newLoc2);
            }

            if (visited[dx1][dy1][dx2][dy2]) return null;
            visited[dx1][dy1][dx2][dy2] = true;
            visited[dx2][dy2][dx1][dy1] = true;
            return new Now(newLoc1, newLoc2);
        }

        public boolean first(int d) {
            if (d == 0) {
                return loc1.x <= loc2.x;
            } else if (d == 1) {
                return loc1.x >= loc2.x;
            } else if (d == 2) {
                return loc1.y <= loc2.y;
            } else {
                return loc1.y >= loc2.y;
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
