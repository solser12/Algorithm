package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로 {

    static int N, ans = Integer.MAX_VALUE;
    static int[][] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);
        br.close();
    }

    static void dfs(int past, int cnt, int dist) {
        if (cnt == N-1) {
            if (list[past][0] == 0) return;
            dist += list[past][0];
            ans = Math.min(dist, ans);
            return;
        }

        if (dist >= ans) return;
        visit[past] = true;

        for (int i = 1; i < N; i++) {
            if (list[past][i] != 0 && !visit[i]) {
                dfs(i, cnt+1, dist+list[past][i]);
            }
        }
        visit[past] = false;
    }
}
