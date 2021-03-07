package SWEA;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7733_치즈도둑 {

    static int [][]  cheese;
    static boolean [][] visit;
    static int N, max;
    static Queue<int[]> q;
    static int[] d = {1, 0, -1, 0 , 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {

            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            max = 0;
            int maxTaste = 0;

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                    maxTaste = cheese[i][j] > maxTaste ? cheese[i][j] : maxTaste;
                }
            }

            for (int day = 1; day < maxTaste; ++day) {

                visit = new boolean[N][N];
                int cnt = 0;

                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        if (cheese[i][j] > day) visit[i][j] = true;
                    }
                }

                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        if (visit[i][j]) {
                            bfs(i, j);
                            cnt++;
                        }
                    }
                }
                max = max < cnt ? cnt : max;
            }

            sb.append('#').append(tc).append(' ').append(max != 0 ? max : 1).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[x][y] = false;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = temp[0] + d[i];
                int dy = temp[1] + d[i+1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && visit[dx][dy]) {
                    visit[dx][dy] = false;
                    q.add(new int[] {dx, dy});
                }
            }
        }

    }
}
