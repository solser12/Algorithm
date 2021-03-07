package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(br.readLine()) + 2;
            boolean[][] map = new boolean[N][N];
            loc[] list = new loc[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[i] = new loc(x, y);
            }

            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    map[i][j] = 1000 >= Math.abs(list[i].x - list[j].x) + Math.abs(list[i].y - list[j].y);
                    map[j][i] = map[i][j];
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i == k) break;
                        if (i == j || map[i][j]) continue;
                        map[i][j] = map[i][k] && map[k][j];
                    }
                }
            }


            if (map[0][N-1]) System.out.println("happy");
            else System.out.println("sad");
        }

        br.close();
    }

    static class loc {
        int x, y;

        public loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
