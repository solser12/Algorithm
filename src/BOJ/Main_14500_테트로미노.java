package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

    static int N, M, ans = 0;
    static int[][] map;
    static int[][] dir = {{1, -1, 0, 0}, {0, 0, 1, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                visit[i][j] = false;
                bfs(i, j);
            }
        }

        System.out.println(ans);
        br.close();
    }

    static void dfs(int x, int y, int depth, int total) {

        if (depth == 3) {
            ans = Math.max(total, ans);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int dx = x + dir[0][d];
            int dy = y + dir[1][d];
            if (dx >= 0 && dx < N && dy >= 0 && dy < M && !visit[dx][dy]) {
                visit[dx][dy] = true;
                dfs(dx, dy, depth + 1, total + map[dx][dy]);
                visit[dx][dy] = false;
            }
        }
    }

    static void bfs(int x, int y) {
        int[] perm = {0, 1, 1, 1};
        int sum;
        do {
            sum = map[x][y];
            for (int i = 0; i < 4; i++) {
                if (perm[i] == 0) continue;
                int dx = x + dir[0][i];
                int dy = y + dir[1][i];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                    sum += map[dx][dy];
                }
            }
            ans = Math.max(ans, sum);
        } while (nextPermutaion(perm));
    }

    static boolean nextPermutaion(int[] perm) {
        int i = 3;
        while(i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = 3;
        while(perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = 3;
        while (i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }
        return true;
    }
}
