package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {

    static int N, M;
    static boolean[][] map;
    static int[][][] step;
    static boolean[][][] visit;
    static int[] d = {0, 1, 0, -1, 1, 0, -1, 0};
    static Queue<Next> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        step = new int[N][M][2];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            for (int j = 0; j < M; ++j) {
                step[i][j][0] = Integer.MAX_VALUE;
                step[i][j][1] = Integer.MAX_VALUE;
                if (input.charAt(j) == '1') map[i][j] = true;
            }
        }
        step[0][0][0] = 0;
        step[0][0][1] = 0;

        q.add(new Next(0, 0, 0));

        System.out.println(bfs());
        br.close();
    }

    static int bfs() {
        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                Next n = q.poll();
                if (n.x == N-1 && n.y == M-1) return step;
                for (int i = 0; i < d.length; i+=2) {
                    int dx = n.x + d[i];
                    int dy = n.y + d[i+1];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                        if (n.wall == 0) {
                            if (map[dx][dy] && !visit[dx][dy][1]) {
                                visit[dx][dy][1] = true;
                                q.add(new Next(dx, dy, 1));
                            }
                            else if (!map[dx][dy] && !visit[dx][dy][0]) {
                                visit[dx][dy][0] = true;
                                q.add(new Next(dx, dy, 0));
                            }
                        }
                        else if (n.wall == 1 && !map[dx][dy] && !visit[dx][dy][1]){
                            visit[dx][dy][1] = true;
                            q.add(new Next(dx, dy, 1));
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }

    static class Next {
        int x, y;
        int wall;

        public Next(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
}
