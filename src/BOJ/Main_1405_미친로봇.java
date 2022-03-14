package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main_1405_미친로봇 {

    public static final long ROUND = 10000000000L;
    public static int N, size;
    public static boolean[][] visited;
    public static int[][] dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static double[] wayProbability = new double[4];
    public static double ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        size = N * 2 + 1;
        visited = new boolean[size][size];
        for (int i = 0; i < 4; i++) {
            wayProbability[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        dfs(0, N, N, 1);

        System.out.println(BigDecimal.valueOf((double) Math.round(ans * ROUND) / ROUND));
        br.close();
    }

    public static void dfs(int depth, int x, int y, double probability) {

        if (depth == N) {
            ans += probability;
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (wayProbability[i] <= 0) continue;

            int dx = x + dt[i][0];
            int dy = y + dt[i][1];
            if (!visited[dx][dy]) {
                dfs(depth + 1, dx, dy, probability * wayProbability[i]);
            }
        }

        visited[x][y] =false;
    }
}