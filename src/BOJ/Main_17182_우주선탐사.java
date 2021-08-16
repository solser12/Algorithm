package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17182_우주선탐사 {

    static int N, K, ans = Integer.MAX_VALUE;
    static int[][] planets;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        planets = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                planets[i][j] = num;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (k == i) continue;
                for (int j = 0; j < N; j++) {
                    planets[k][j] = Math.min(planets[k][j], planets[k][i] + planets[i][j]);
                }
            }
        }

        visited[K] = true;
        dfs(1, K, 0);

        System.out.println(ans);
        br.close();
    }

    public static void dfs(int depth, int num, int sum) {

        if (sum >= ans) return;

        if (depth == N) {
            ans = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, i, sum + planets[num][i]);
            visited[i] = false;
        }
    }
}
