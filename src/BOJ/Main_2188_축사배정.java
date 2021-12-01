package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2188_축사배정 {

    public static int N, M;
    public static boolean[] visited;
    public static int[] cowshed;
    public static int[][] cows;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cowshed = new int[M];
        visited = new boolean[M];
        cows = new int[N + 1][];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            cows[i] = new int[size];
            for (int j = 0; j < size; j++) {
                cows[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            if (dfs(i)) ans++;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean dfs(int cow) {
        for (int i = 0; i < cows[cow].length; i++) {
            if (visited[cows[cow][i]]) continue;
            visited[cows[cow][i]] = true;

            if (cowshed[cows[cow][i]] == 0 || dfs(cowshed[cows[cow][i]])) {
                cowshed[cows[cow][i]] = cow;
                return true;
            }
        }
        return false;
    }
}
