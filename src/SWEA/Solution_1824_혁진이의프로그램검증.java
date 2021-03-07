package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1824_혁진이의프로그램검증 {

    static int R, C;
    static char[][] map;
    static boolean[][][][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            visit = new boolean[R][C][16][4];
            boolean checkExit = false;
            boolean result = false;

            for (int i = 0; i < R; i++) {
                String input = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') checkExit = true;
                }
            }

            if (checkExit) result = algorithm();

            sb.append('#').append(t).append(' ').append(result ? "YES" : "NO").append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static boolean algorithm() {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, C-1, 0, 3));

        // bfs
        while(!q.isEmpty()) {
            Loc now = q.poll();
            move(now);
            if (map[now.x][now.y] == '@') return true;
            else if (map[now.x][now.y] == '?') {
                for (int i = 0; i < 4; i++) {
                    Loc loc = new Loc(now.x, now.y, now.memory, i);
                    if (!visit[loc.x][loc.y][loc.memory][loc.way]) {
                        q.add(loc);
                        visit[loc.x][loc.y][loc.memory][loc.way] = true;
                    }

                }
            }
            else {
                check(now);
                if (!visit[now.x][now.y][now.memory][now.way]) {
                    q.add(now);
                    visit[now.x][now.y][now.memory][now.way] = true;
                }
            }
        }

        return false;
    }

    static void check(Loc now) {
        char command = map[now.x][now.y];
        int memory = now.memory;
        int way = now.way;

        if (command == '<') now.way = 2;
        else if (command == '>') now.way = 3;
        else if (command == '^') now.way = 0;
        else if (command == 'v') now.way = 1;
        else if (command == '_') {
            if (memory == 0) now.way = 3;
            else now.way = 2;
        }
        else if (command == '|') {
            if (memory == 0) now.way = 1;
            else now.way = 0;
        }
        else if (command >= '0' && command <= '9') now.memory = command - '0';
        else if (command == '+') now.memoryUp();
        else if (command == '-') now.memoryDown();
    }

    static void move(Loc now) {
        int way = now.way;
        switch (way) {
            case 0:
                now.up();
                break;
            case 1:
                now.down();
                break;
            case 2:
                now.left();
                break;
            case 3:
                now.right();
                break;
        }
    }

    static class Loc {
        int x, y, memory, way;

        public Loc(int x, int y, int memory, int way) {
            this.x = x;
            this.y = y;
            this.memory = memory;
            this.way = way;
        }

        public void up() {
            x--;
            if (x < 0) x = R-1;
        }
        public void down() {
            x++;
            if (x >= R) x = 0;
        }
        public void left() {
            y--;
            if (y < 0) y = C-1;
        }
        public void right() {
            y++;
            if (y >= C) y = 0;
        }
        public void memoryUp() {
            memory++;
            if (memory > 15) memory = 0;
        }
        public void memoryDown() {
            memory--;
            if (memory < 0) memory = 15;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "x=" + x +
                    ", y=" + y +
                    ", memory=" + memory +
                    ", way=" + way +
                    '}';
        }
    }
}
