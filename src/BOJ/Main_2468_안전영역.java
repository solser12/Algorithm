package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

    static int N, max = -1;
    static int[][] map;
    static boolean[][] tmap;
    static Queue<int[]> q;
    static int[] d = {1, 0, -1, 0, 0, 1, 0 ,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        tmap = new boolean[N][N];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r <= 100; ++r) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    tmap[i][j] = map[i][j] > r ? true : false;
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (tmap[i][j]) {
                        q = new LinkedList<>();
                        q.add(new int[]{i, j});
                        tmap[i][j] = false;
                        bfs();
                        cnt++;
                    }
                }
            }
            if (cnt != 0 && cnt > max) {
                max = cnt;
            }
            else if (cnt == 0) break;
        }

        System.out.println(max);
        br.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = temp[0] + d[i];
                int dy = temp[1] + d[i+1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && tmap[dx][dy]) {
                    q.add(new int[] {dx, dy});
                    tmap[dx][dy] = false;
                }
            }
        }
    }
}
