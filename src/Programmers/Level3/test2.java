package Programmers.Level3;

import java.util.Arrays;

public class test2 {

    public int[][] map;
    public final int INF = 1000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int[] fare : fares) {
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }

        floydWarshall(n);

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) { // 거처갈 도시
            ans = Math.min(ans, map[s][i] + map[i][a] + map[i][b]);
        }

        return ans;
    }

    public void floydWarshall(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
