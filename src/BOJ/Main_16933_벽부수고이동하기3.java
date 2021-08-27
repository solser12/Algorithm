package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16933_벽부수고이동하기3 {

    static int N, M, K;
    static boolean[][] map;
    static int[][][] visited;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M][K+1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int c = input.charAt(j) - '0';
                map[i][j] = c == 1;
                for (int k = 0; k <= K; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {

        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, 1, 0, false));
        visited[0][0][0] = 1;
        boolean night = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                State state = q.poll();
                if (!state.stay && visited[state.x][state.y][state.cnt] < state.step) {
                    continue;
                }

                if (state.x == N - 1 && state.y == M - 1) {
                    return state.step;
                }

                int len = night ? 5 : 4;
                for (int d = 0; d < len; d++) {
                    int dx = state.x + dt[d][0];
                    int dy = state.y + dt[d][1];
                    if (check(dx, dy)) {
                        if (night) {
                            if (d != 4) {
                                if (map[dx][dy]) continue;
                                if (visited[dx][dy][state.cnt] <= state.step + 1) continue;
                                visited[dx][dy][state.cnt] = state.step + 1;
                                q.offer(new State(dx, dy, state.step + 1, state.cnt, false));
                            } else {
                                q.offer(new State(dx, dy, state.step + 1, state.cnt, true));
                            }
                        } else {
                            int cnt = state.cnt + (map[dx][dy] ? 1 : 0);
                            if (cnt > K) continue;
                            if (visited[dx][dy][cnt] <= state.step + 1) continue;
                            visited[dx][dy][cnt] = state.step + 1;
                            q.offer(new State(dx, dy, state.step + 1, cnt, false));
                        }
                    }
                }
            }

            night = !night;
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class State {
        int x, y, step, cnt;
        boolean stay;

        public State(int x, int y, int step, int cnt, boolean stay) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.cnt = cnt;
            this.stay = stay;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    ", step=" + step +
                    ", cnt=" + cnt +
                    ", stay=" + stay +
                    '}';
        }
    }
}
