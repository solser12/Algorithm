package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

    static int[][] map;
    static int[] d = {-1, -1, -1, 0, -1, 1, 0, 1, 0, -1, 1, -1, 1, 0, 1, 1};
    static Queue<int[]> q = new LinkedList();
    static int h, w;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[h][w];

            for (int i = 0; i < h; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void bfs(int m, int n) {
        map[m][n] = 2;
        q.add(new int[] {m, n});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = temp[0] + d[i];
                int dy = temp[1] + d[i+1];
                if (dx >= 0 && dx < h && dy >= 0 && dy < w && map[dx][dy] == 1) {
                    q.add(new int[] {dx, dy});
                    map[dx][dy] = 2;
                }
            }
        }
    }
}