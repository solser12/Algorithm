package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {

    static boolean[][] x, y;
    static boolean[][][] area;
    static int[][] sudoku;
    static ArrayList<Loc> empty = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        x = new boolean[9][10];
        y = new boolean[9][10];
        area = new boolean[3][3][10];
        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    sudoku[i][j] = num;
                    x[i][num] = true;
                    y[j][num] = true;
                    area[i/3][j/3][num] = true;
                } else {
                    empty.add(new Loc(i, j));
                }
            }
        }

        check(0);

        for (int[] ints : sudoku) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean check(int index) {

        if (index == empty.size()) {
            return true;
        }

        Loc loc = empty.get(index);
        for (int i = 1; i <= 9; i++) {
            if (x[loc.x][i] || y[loc.y][i] || area[loc.x / 3][loc.y / 3][i]) continue;
            x[loc.x][i] = true;
            y[loc.y][i] = true;
            area[loc.x/3][loc.y/3][i] = true;
            sudoku[loc.x][loc.y] = i;

            if (check(index + 1)) return true;

            x[loc.x][i] = false;
            y[loc.y][i] = false;
            area[loc.x/3][loc.y/3][i] = false;
            sudoku[loc.x][loc.y] = 0;
        }

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
