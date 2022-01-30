package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {

    public static int[][] dt = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            int L, R, C;
            char[][][] building;

            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0) break;

            building = new char[L][R][C];
            Now start = null;
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    String data = br.readLine();
                    for (int j = 0; j < C; j++) {
                        char c = data.charAt(j);
                        if (c == 'S') start = new Now(k, i, j);
                        else building[k][i][j] = data.charAt(j);
                    }
                }
                br.readLine();
            }

            int result = bfs(L, R, C, start, building);
            if (result == -1) sb.append("Trapped!\n");
            else sb.append(String.format("Escaped in %d minute(s).", result)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(int L, int R, int C, Now start, char[][][] building) {
        Queue<Now> q = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        q.offer(start);
        visited[start.floor][start.x][start.y] = true;

        int min = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Now now = q.poll();
                for (int d = 0; d < 6; d++) {
                    int df = now.floor + dt[d][0];
                    int dx = now.x + dt[d][1];
                    int dy = now.y + dt[d][2];
                    if (check(L, R, C, df, dx, dy, visited)) {
                        if (building[df][dx][dy] == '.') {
                            visited[df][dx][dy] = true;
                            q.offer(new Now(df, dx, dy));
                        } else if (building[df][dx][dy] == 'E') {
                            return min;
                        }
                    }
                }
            }
            min++;
        }

        return -1;
    }

    public static boolean check(int L, int R, int C, int df, int dx, int dy, boolean[][][] visited) {
        return df >= 0 && df < L && dx >= 0 && dx < R && dy >= 0 && dy < C && !visited[df][dx][dy];
    }

    public static class Now {
        int floor, x, y;

        public Now(int floor, int x, int y) {
            this.floor = floor;
            this.x = x;
            this.y = y;
        }
    }
}
