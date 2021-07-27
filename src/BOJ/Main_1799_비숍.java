package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1799_비숍 {

    static int N, ans = 0;
    static int [][] board;
    static int[][] dt = {{1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int blackAll = 0;   // 0, 0
        int whiteAll = 0;   // 0, 1
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                board[i][j] = data;
                if ((i + j) % 2 == 0) {
                    blackAll += data;
                } else {
                    whiteAll += data;
                }
            }
        }
        int result = 0;
        find(0, 0, 0, blackAll);
        result += ans;
        ans = 0;
        find(0, 1, 0, whiteAll);
        result += ans;

        System.out.println(result);
        br.close();
    }

    public static void find(int x, int y, int cnt, int all) {

        // 가망 없으면 return
        if (ans >= cnt + all) return;

        if (all == 0) {
//            for (int[] ints : board) {
//                for (int i : ints) {
//                    if (i == 9) System.out.print("B\t");
//                    else System.out.print("-\t");
//                }
//                System.out.println();
//            }
//            System.out.println();
            ans = Math.max(ans, cnt);
            return;
        }

        if (y >= N) {
            x++;
            if (((x - 1) + y) % 2 == 0) {
                if (x % 2 == 0) y = 0;
                else y = 1;
            } else {
                if (x % 2 == 0) y = 1;
                else y = 0;
            }
        }

        if (board[x][y] == 1) {
            // 비숍을 놓고 처리하기
            int delete = all - change(x, y);
            find(x, y + 2, cnt + 1, delete);
            clear(x, y);

            // 비숍 안놓고 처리하기
            find(x, y + 2, cnt, all - 1);
        } else {
            // 비숍을 못 놓는 곳이면 넘어가기
            find(x, y + 2, cnt, all);
        }
    }

    public static void clear(int x, int y) {
        board[x][y] = 1;
        int dx = x + dt[0][0], dy = y + dt[0][1];
        while (dx >= 0 && dx < N && dy >= 0 && dy < N) {

            if (board[dx][dy] > 1) {
                board[dx][dy]--;
            }

            dx += dt[0][0];
            dy += dt[0][1];
        }

        dx = x + dt[1][0]; dy = y + dt[1][1];
        while (dx >= 0 && dx < N && dy >= 0 && dy < N) {

            if (board[dx][dy] > 1) {
                board[dx][dy]--;
            }

            dx += dt[1][0];
            dy += dt[1][1];
        }
    }

    public static int change(int x, int y) {
        int cnt = 1;
        board[x][y] = 9;
        int dx = x + dt[0][0], dy = y + dt[0][1];

        while (dx >= 0 && dx < N && dy >= 0 && dy < N) {

            if (board[dx][dy] > 0) {
                if (board[dx][dy] == 1) {
                    cnt++;
                }
                board[dx][dy]++;
            }

            dx += dt[0][0];
            dy += dt[0][1];
        }

        dx = x + dt[1][0]; dy = y + dt[1][1];

        while (dx >= 0 && dx < N && dy >= 0 && dy < N) {

            if (board[dx][dy] > 0) {
                if (board[dx][dy] == 1) {
                    cnt++;
                }
                board[dx][dy]++;
            }

            dx += dt[1][0];
            dy += dt[1][1];
        }

        return cnt;
    }
}
