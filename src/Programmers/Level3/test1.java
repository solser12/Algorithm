package Programmers.Level3;

import java.util.Arrays;

public class test1 {

    public int[] board;
    public int ans = 0;

    public int solution(int n) {

        board = new int[n];
        Arrays.fill(board, -1);

        dfs(0, n);

        return ans;
    }

    public void dfs(int depth, int n) {

        if (depth == n) {
            ans++;
        }

        for (int i = 0; i < n; i++) {
            if (check(depth, i)) {
                board[depth] = i;
                dfs(depth + 1, n);
            }
        }
    }

    public boolean check(int depth, int num) {
        int left = num - 1, right = num + 1;

        for (int i = depth - 1; i >= 0; i--) {
            if (board[i] == num || board[i] == left || board[i] == right) {
                return false;
            }
            left--;
            right++;
        }

        return true;
    }
}
