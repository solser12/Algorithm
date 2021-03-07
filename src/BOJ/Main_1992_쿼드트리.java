package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {

    static int N;
    static boolean[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        video = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if(input.charAt(j) == '1') {
                    video[i][j] = true;
                }
            }
        }

        Divide(0, 0, N);
        System.out.println(sb);
        br.close();
    }

    static void Divide(int x, int y, int n) {

        if (n == 1) {
            sb.append(video[x][y] ? 1 : 0);
            return;
        }

        boolean check = video[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (check != video[i][j]) {
                    int div = n / 2;
                    sb.append('(');
                    Divide(x, y, div);
                    Divide(x, y + div, div);
                    Divide(x + div, y, div);
                    Divide(x + div, y + div, div);
                    sb.append(')');
                    return;
                }
            }
        }

        sb.append(check ? 1 : 0);
    }
}
