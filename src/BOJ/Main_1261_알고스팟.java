package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {

    static boolean[][] map;
    static int[][] step;
    static Queue<int[]> q = new LinkedList<>();
    static int[] d = {1, 0, -1, 0, 0, 1, 0, -1};
    static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        step = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            for (int j = 0; j < M; ++j) {
                step[i][j] = Integer.MAX_VALUE;
                if (input.charAt(j) - '0' == 1) map[i][j] = true;
            }
        }

        step[0][0] = 0;

        q.add(new int[]{0, 0});
        bfs();

        System.out.println(step[N - 1][M - 1]);
        br.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i += 2) {
                int x = temp[0] + d[i];
                int y = temp[1] + d[i+1];
                if (x >= 0 && x < N && y >= 0 && y < M && (map[x][y] && (step[temp[0]][temp[1]] + 1 < step[x][y]) || (!map[x][y]) && step[temp[0]][temp[1]] < step[x][y])) {
                    q.add(new int[] {x, y});
                    if (map[x][y]) step[x][y] = step[temp[0]][temp[1]] + 1;
                    else step[x][y] = step[temp[0]][temp[1]];
                }
            }
        }
    }
}
