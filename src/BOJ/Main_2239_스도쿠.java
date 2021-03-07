package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {

    static int[][] sudoku;
    static boolean[][] checkX, checkY, checkArea;
    static boolean find;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        checkX = new boolean[9][10];
        checkY = new boolean[9][10];
        checkArea = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            String string = br.readLine();
            for (int j = 0; j < 9; j++) {
                int input = string.charAt(j) - '0';
                sudoku[i][j] = input;
                if (sudoku[i][j] != 0) {
                    checkX[i][input] = true;
                    checkY[j][input] = true;
                    checkArea[getSection(i, j)][input] = true;
                    cnt++;
                }
            }
        }

        findResult(0, -1, cnt);

        for (int[] a : sudoku) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
        br.close();
    }

    public static void findResult(int x, int y, int count) {
        if (count == 81) {
            find = true;
            return;
        }
        int j = y;
        for (int i = x; i < 9; i++) {
            while (true) {
                j++;
                if (j >= 9) break;
                else if (sudoku[i][j] != 0) continue;
                for (int k = 1; k <= 9; k++) {
                    if (checkX[i][k] || checkY[j][k] || checkArea[getSection(i, j)][k]) continue;
                    checkX[i][k] = true;
                    checkY[j][k] = true;
                    checkArea[getSection(i, j)][k] = true;
                    sudoku[i][j] = k;
                    findResult(i, j, count+1);
                    if (find) return;
                    checkX[i][k] = false;
                    checkY[j][k] = false;
                    checkArea[getSection(i, j)][k] = false;
                    sudoku[i][j] = 0;
                }
                return;
            }
            j = -1;
        }
    }

    public static int getSection(int x, int y) {
        x /= 3;
        y /= 3;
        if (x == 0) {
            if (y == 0) return 0;
            else if (y == 1) return 1;
            else return 2;
        }
        else if (x == 1) {
            if (y == 0) return 3;
            else if (y == 1) return 4;
            else return 5;
        }
        else {
            if (y == 0) return 6;
            else if (y == 1) return 7;
            else return 8;
        }
    }
}