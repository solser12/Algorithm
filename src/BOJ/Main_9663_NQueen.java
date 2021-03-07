package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9663_NQueen {
    static int cnt; // 퀸을 안전하게 놓을 수 있는 경우의 수
    static int N; // 전체 체스판 크기 == 퀸 갯수
    static int[] queen;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];
        cnt = 0;

        backtracking(0);

        System.out.println(cnt);
        br.close();
    }

    static void backtracking(int r) {

        if (r == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checking(r, i)) {
                queen[r] = i;
                backtracking(r+1);
            }
        }
    }

    static boolean checking(int r, int x) {

        for (int i = 0; i < r; i++) {
            if (queen[i] == x) return false;
            if (queen[i] + (r - i) == x) {
                return false;
            }
            if (queen[i] - (r - i) == x) {
                return false;
            }
        }
        return true;
    }
}