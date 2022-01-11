package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16931_겉넓이구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int d = 0; d < 4; d++) {
                    int dx = i + dt[d][0];
                    int dy = j + dt[d][1];
                    if (paper[i][j] > paper[dx][dy]) {
                        ans += paper[i][j] - paper[dx][dy];
                    }
                }
            }
        }

        ans += N * M * 2;

        System.out.println(ans);
        br.close();
    }
}
