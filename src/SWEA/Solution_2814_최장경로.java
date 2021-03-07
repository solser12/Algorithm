package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2814_최장경로 {

    static int N, M, ans;
    static boolean[][] list;
    static int[][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   // 노드 수
            M = Integer.parseInt(st.nextToken());   // 간선 수
            ans = 0;

            list = new boolean[N][N];
            memo = new int[N][1 << (N + 1)];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                list[x][y] = true;
                list[y][x] = true;
            }

            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, dfs(i, 1 << i));
            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static int dfs(int start, int visited) {
        int ret = 1;

        if (memo[start][visited] != 0) return memo[start][visited];

        for (int i = 0; i < N; i++) {
            // 간선이 없을 떼
            if (!list[start][i]) continue;

            // 이미 방문되어 있을 때
            if ((visited & (1 << i)) != 0) continue;

            ret = Math.max(ret, dfs(i, visited | (1 << i)) + 1);
        }

        memo[start][visited] = ret;
        return ret;
    }
}
