package Programmers;

import java.util.*;

public class 리틀프렌즈사천성 {

    public String solution(int m, int n, String[] board) {

        int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        char[][] gameBoard = new char[m][n];
        HashSet<Character> set = new HashSet<>();
        PriorityQueue<Tile> tiles = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
                if (!set.contains(gameBoard[i][j]) && 'A' <= gameBoard[i][j] && gameBoard[i][j] <= 'Z') {
                    set.add(gameBoard[i][j]);
                    tiles.offer(new Tile(gameBoard[i][j], new Loc(i, j)));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Tile> temp = new ArrayList<>();
        while (tiles.size() != 0) {

            Tile tile = tiles.poll();
            if (bfs(m, n, tile.c, dt, tile.loc, gameBoard)) {
                sb.append(tile.c);
                for (Tile t : temp) {
                    tiles.offer(t);
                }
                temp.clear();
            } else {
                temp.add(tile);
            }
        }

        if (temp.size() > 0) {
            sb.setLength(0);
            sb.append("IMPOSSIBLE");
        }

        return sb.toString();
    }

    public boolean bfs(int m, int n, char c, int[][] dt, Loc start, char[][] gameBoard) {

        boolean[][][] visited = new boolean[4][m][n];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(start, -1, -1));
        for (int i = 0; i < 4; i++) {
            visited[i][start.x][start.y] = true;
        }

        while (!q.isEmpty()) {
            State state = q.poll();

            for (int d = 0; d < 4; d++) {

                if (state.way != d && state.turnCnt >= 1) {
                    continue;
                }

                int dx = state.loc.x + dt[d][0];
                int dy = state.loc.y + dt[d][1];
                if (check(m, n, dx, dy, c, gameBoard, visited[d])) {

                    if (gameBoard[dx][dy] == c) {
                        gameBoard[start.x][start.y] = '.';
                        gameBoard[dx][dy] = '.';
                        return true;
                    }

                    visited[d][dx][dy] = true;
                    q.offer(new State(new Loc(dx, dy), d, state.turnCnt + (state.way == d ? 0 : 1)));
                }
            }
        }

        return false;
    }

    public boolean check(int m, int n, int x, int y, char c, char[][] gameBoard, boolean[][] visited) {
        return 0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && (gameBoard[x][y] == '.' || gameBoard[x][y] == c);
    }

    public class Tile implements Comparable<Tile> {
        char c;
        Loc loc;

        public Tile(char c, Loc loc) {
            this.c = c;
            this.loc = loc;
        }

        @Override
        public int compareTo(Tile o) {
            return this.c - o.c;
        }
    }

    public class State {

        Loc loc;
        int way, turnCnt;

        public State(Loc loc, int way, int turnCnt) {
            this.loc = loc;
            this.way = way;
            this.turnCnt = turnCnt;
        }
    }

    public class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
