package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

    static int N, M, step = 1;
    static boolean[][] map;
    static int[] d = {0, 1, 0, -1, 1, 0, -1, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '1') map[i][j] = true;
            }
        }

        q.add(new int[]{0, 0});
        map[0][0] = false;
        bfs();

        System.out.println(step);
        br.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int j = 0; j < d.length; j+=2) {
                    int dx = temp[0] + d[j];
                    int dy = temp[1] + d[j+1];
                    if (dx == N -1 && dy == M - 1) {
                        step++;
                        return;
                    }
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M && map[dx][dy]) {
                        q.add(new int[] {dx, dy});
                        map[dx][dy] = false;
                    }
                }
            }
            step++;
        }
    }
}
