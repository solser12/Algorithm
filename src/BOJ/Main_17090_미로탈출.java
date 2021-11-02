package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17090_미로탈출 {

    static int[][] map, visited;
    static boolean[] successCheck;
    static int N, M, num = 1, ans = 0;
    static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        successCheck = new boolean[N * M + 1];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == 'U') map[i][j] = 0;
                else if (c == 'R') map[i][j] = 1;
                else if (c == 'D') map[i][j] = 2;
                else map[i][j] = 3;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] != 0) continue;
                dfs(i, j, 0);
                num++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void dfs(int x, int y, int count) {

        if (check(x, y)) {
            successCheck[num] = true;
            ans += count;
            return;
        } else if (visited[x][y] != 0) {
            if (successCheck[visited[x][y]]) {
                successCheck[num] = true;
                ans += count;
            }
            return;
        }

        visited[x][y] = num;
        dfs(x + dt[map[x][y]][0],  y + dt[map[x][y]][1], count + 1);
    }

    public static boolean check(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}
