package Programmers;

import java.util.Arrays;

public class 프렌즈4블록 {

    static int ans = 0;
    static char[][] game, temp;
    static int[][] dt = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};

    public int solution(int m, int n, String[] board) {

        temp = new char[m][n];
        game = new char[m][];
        for (int i = 0; i < m; i++) {
            game[i] = board[i].toCharArray();
        }

        while (check(m, n)) {
            game = down(m, n);
        }

        return ans;
    }

    public char[][] down(int m, int n) {

        char[][] move = new char[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(move[i], ' ');
        }

        for (int i = 0; i < n; i++) {
            int idx = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (temp[j][i] != ' ') {
                    move[idx--][i] = temp[j][i];
                }
            }
        }

        return move;
    }

    public boolean check(int m, int n) {

        for (int i = 0; i < m; i++) {
            temp[i] = game[i].clone();
        }

        boolean flag = false;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (game[i][j] == ' ') continue;
                boolean find = true;
                for (int d = 1; d < 4; d++) {
                    int dx = i + dt[d][0];
                    int dy = j + dt[d][1];
                    if (game[i][j] != game[dx][dy]) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    for (int d = 0; d < 4; d++) {
                        int dx = i + dt[d][0];
                        int dy = j + dt[d][1];
                        if (temp[dx][dy] != ' ') {
                            ans++;
                            temp[dx][dy] = ' ';
                        }
                    }
                    flag = true;
                }
            }
        }

        return flag;
    }
}
