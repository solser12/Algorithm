package Programmers.kako2019internship;

import java.util.Stack;

public class 크레인인형뽑기게임 {

    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {

        Stack<Integer>[] machine = new Stack[board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            machine[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                machine[j].push(board[i][j]);
            }
        }

        int ans = 0;
        Stack<Integer> storage = new Stack<>();
        for (int m : moves) {
            int move = m - 1;
            if (!machine[move].isEmpty()) {
                int doll = machine[move].pop();
                if (!storage.isEmpty() && storage.peek() == doll) {
                    storage.pop();
                    ans += 2;
                } else {
                    storage.push(doll);
                }
            }
        }

        return ans;
    }
}
