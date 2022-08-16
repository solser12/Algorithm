package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프 {

    public static int[][] board = new int[5][5];
    public static HashSet<Integer> set = new HashSet<>();
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, 0, 1, i, j);
            }
        }

        System.out.println(set.size());
        br.close();
    }

    public static void dfs(int depth, int sum, int index ,int x, int y) {

        if (depth == 6) {
            set.add(sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dx = x + dt[i][0];
            int dy = y + dt[i][1];
            if (check(dx, dy)) {
                dfs(depth + 1, sum + (board[dx][dy] * index), index * 10, dx, dy);
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }
}
