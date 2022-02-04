package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080_행렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] start = new boolean[N][M];
        boolean[][] end = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                start[i][j] = (input.charAt(j) - '0') == 1;
            }
        }
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                end[i][j] = (input.charAt(j) - '0') == 1;
            }
        }

        int ans = 0;
        if (N >= 3 && M >= 3) {
            for (int i = 0; i < N - 2; i++) {
                for (int j = 0; j < M - 2; j++) {
                    if (start[i][j] != end[i][j]) {
                        ans++;
                        change(i, j, start);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (start[i][j] != end[i][j]) {
                        ans = -1;
                        i = N;
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (start[i][j] != end[i][j]) {
                        ans = -1;
                        i = N;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void change(int x, int y, boolean[][] start) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                start[i][j] = !start[i][j];
            }
        }
    }
}
