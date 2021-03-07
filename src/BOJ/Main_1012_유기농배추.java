package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {

    static int N, M, K;
    static boolean[][] farm;
    static int cnt;
    static int[] d = {0, 1, 0 , -1, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            farm = new boolean[N][M];
            cnt = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = true;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (farm[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        farm[x][y] = false;

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = loc.x + d[i];
                int dy = loc.y + d[i+1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M && farm[dx][dy]) {
                    q.add(new Loc(dx, dy));
                    farm[dx][dy] = false;
                }
            }
        }
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
