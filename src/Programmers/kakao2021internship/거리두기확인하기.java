package Programmers.kakao2021internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {

    public static void main(String[] args) {

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    public static char[][] room = new char[5][5];
    public static ArrayList<Loc> pLoc = new ArrayList<>();
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[] solution(String[][] places) {

        int[] result = new int[5];

        for (int k = 0; k < 5; k++) {
            pLoc.clear();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    room[i][j] = places[k][i].charAt(j);
                    if (room[i][j] == 'P') {
                        pLoc.add(new Loc(i, j));
                    }
                }
            }

            result[k] = check();
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    public static int check() {

        for (Loc loc : pLoc) {
            if (!bfs(loc)) {
                return 0;
            }
        }

        return 1;
    }

    public static boolean bfs(Loc loc) {

        Queue<Loc> q = new LinkedList<>();
        q.offer(loc);
        room[loc.x][loc.y] = 'V';

        int len = 0;
        while (!q.isEmpty() && len < 2) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = now.x + dt[d][0];
                    int dy = now.y + dt[d][1];
                    if (check(dx, dy)) {
                        if (room[dx][dy] == 'O') {
                            q.offer(new Loc(dx, dy));
                            room[dx][dy] = 'V';
                        } else if (room[dx][dy] == 'P') {
                            return false;
                        }
                    }
                }
            }

            len++;
        }

        return true;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
