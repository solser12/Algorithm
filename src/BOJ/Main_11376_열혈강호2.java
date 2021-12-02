package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11376_열혈강호2 {

    public static int N, M;
    public static boolean[] visited;
    public static int[] work;
    public static int[][] possible;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M];
        work = new int[M];
        possible = new int[N * 2 + 1][];

        for (int i = 1; i <= N * 2; i += 2) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            possible[i] = new int[num];
            possible[i + 1] = new int[num];
            for (int j = 0; j < num; j++) {
                possible[i][j] = Integer.parseInt(st.nextToken()) - 1;
                possible[i + 1][j] = possible[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= N * 2; i++) {
            Arrays.fill(visited, false);
            if (dfs(i)) ans++;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean dfs(int num) {
        for (int i = 0; i < possible[num].length; i++) {
            if (visited[possible[num][i]]) continue;
            visited[possible[num][i]] = true;

            if (work[possible[num][i]] == 0 || dfs(work[possible[num][i]])) {
                work[possible[num][i]] = num;
                return true;
            }
        }
        return false;
    }
}
