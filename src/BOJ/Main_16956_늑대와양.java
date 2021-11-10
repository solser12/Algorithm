package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16956_늑대와양 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] farm = new char[R][C];

        ArrayList<Loc> wolves = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                farm[i][j] = input.charAt(j);
                if (farm[i][j] == 'W') {
                    wolves.add(new Loc(i, j));
                }
            }
        }

        for (Loc wolf : wolves) {
            for (int d = 0; d < 4; d++) {
                int dx = wolf.x + dt[d][0];
                int dy = wolf.y + dt[d][1];
                if (dx >= 0 && dx < R && dy >= 0 && dy < C) {
                    if (farm[dx][dy] == 'S') {
                        System.out.println('0');
                        System.exit(0);
                    } else if (farm[dx][dy] == '.') {
                        farm[dx][dy] = 'D';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(farm[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
