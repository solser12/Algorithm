package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {

    public static int ans = 0;
    public static Board start;
    public static Board[] pieces = new Board[4];
    public static int[] dice = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeBoard();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(ans);
        br.close();
    }

    public static void dfs(int depth, int sum) {

        if (depth == 10) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (pieces[i] == null) continue;

            Board now = pieces[i];
            Board move = now.move(dice[depth]);

            now.isUsed = false;
            if (move == null) {
                pieces[i] = null;
                dfs(depth + 1, sum);

            } else if (!move.isUsed) {
                move.isUsed = true;
                pieces[i] = move;
                dfs(depth + 1, sum + move.point);

                move.isUsed = false;
            }

            now.isUsed = true;
            pieces[i] = now;
        }
    }

    public static void makeBoard() {

        start = new Board();
        Board end = start, mid = new Board(25);
        Board[] temp = new Board[3];

        // 일반 길
        for (int i = 1; i <= 20; i++) {
            end.next = new Board(i * 2);
            if (i % 5 == 0 && i < 20) {
                temp[i / 5 - 1] = end.next;
            }
            end = end.next;
        }

        // 중앙 지름길에서 도착으로 가는 길
        Board boardTemp = mid;
        for (int i = 1; i <= 2; i++) {
            boardTemp.next = new Board(25 + (i * 5));
            boardTemp = boardTemp.next;
        }
        boardTemp.next = end;

        // 지름길 설정
        boardTemp = temp[0];
        boardTemp.hiddenNext = new Board(13);
        boardTemp = boardTemp.hiddenNext;
        for (int i = 2; i <= 3; i++) {
            boardTemp.next = new Board(10 + (i * 3));
            boardTemp = boardTemp.next;
        }
        boardTemp.next = mid;

        boardTemp = temp[2];
        int point = 28;
        boardTemp.hiddenNext = new Board(point);
        boardTemp = boardTemp.hiddenNext;
        for (int i = 0; i < 2; i++) {
            point -= 1;
            boardTemp.next = new Board(point);
            boardTemp = boardTemp.next;
        }
        boardTemp.next = mid;

        boardTemp = temp[1];
        boardTemp.hiddenNext = new Board(22);
        boardTemp = boardTemp.hiddenNext;
        boardTemp.next = new Board(24);
        boardTemp = boardTemp.next;
        boardTemp.next = mid;

        // 말들 출발지로 모이기
        Arrays.fill(pieces, start);
    }

    public static class Board {
        int point;
        Board next, hiddenNext;
        boolean isUsed = false;

        public Board() { }

        public Board(int point) {
            this.point = point;
        }

        public Board move(int num) {
            Board temp;
            if (hiddenNext == null) temp = this.next;
            else temp = this.hiddenNext;

            for (int i = 1; i < num; i++) {
                if (temp == null) break;
                temp = temp.next;
            }
            return temp;
        }
    }
}
