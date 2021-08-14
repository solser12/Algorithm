package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {

    static int R, C, N;
    static char[][][] map;
    static int[][] dt = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[4][R][C];
        // 0 : start, 1 : full, 2 : next, 3 : 2next

        for (int i = 0; i < R; i++) {
            Arrays.fill(map[1][i], 'O');
            Arrays.fill(map[2][i], 'O');
            Arrays.fill(map[3][i], 'O');
        }

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                map[0][i][j] = c;
                if (c == 'O') {
                    for (int d = 0; d < 5; d++) {
                        int dx = i + dt[d][0];
                        int dy = j + dt[d][1];

                        if (dx >= 0 && dx < R && dy >= 0 && dy < C) {
                            map[2][dx][dy] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[2][i][j] == 'O') {
                    for (int d = 0; d < 5; d++) {
                        int dx = i + dt[d][0];
                        int dy = j + dt[d][1];

                        if (dx >= 0 && dx < R && dy >= 0 && dy < C) {
                            map[3][dx][dy] = '.';
                        }
                    }
                }
            }
        }

        int ch;

       if (N == 1) {
           ch = 0;
       } else if (N % 2 == 0) {
           ch = 1;
       } else {
           if (N % 4 == 1) {
               ch = 3;
           } else {
               ch = 2;
           }
       }

        for (int i = 0; i < R; i++) {
            sb.append(String.valueOf(map[ch][i])).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
