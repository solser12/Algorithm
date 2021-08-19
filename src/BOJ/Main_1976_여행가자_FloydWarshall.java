package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자_FloydWarshall {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int start = -1, end;
        String ans = "YES";

        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    map[i][j] = true;
                }

                if (i == j) map[i][j] = true;
            }
        }

        for (int k = 0; k < N - 1; k++) {
            for (int i = 0; i < N; i++) {
                if (k == i) continue;
                for (int j = 0; j < N; j++) {
                    if (k == j || map[k][j]) continue;
                    if (map[k][i] && map[i][j]) {
                        map[k][j] = true;
                        map[j][k] = true;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;

            if (start == -1) {
                start = num;
                continue;
            }

            end = num;

            if (!map[start][end]) {
                ans = "NO";
                break;
            }

            start = end;
        }

        System.out.println(ans);
        br.close();
    }
}
