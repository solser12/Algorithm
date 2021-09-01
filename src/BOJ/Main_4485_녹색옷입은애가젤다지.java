package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

    static int N;
    static int[][] map;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }

            }

            sb.append("Problem ").append(T++).append(": ").append(bfs()).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs() {

        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.offer(new Loc(0, 0, map[0][0]));
        visited[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Loc loc = pq.poll();
            if (visited[loc.x][loc.y] < loc.lost) continue;

            if (loc.x == N - 1 && loc.y == N - 1) {
                return loc.lost;
            }

            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
                    int lost = loc.lost + map[dx][dy];
                    if (visited[dx][dy] > lost) {
                        visited[dx][dy] = lost;
                        pq.offer(new Loc(dx, dy, lost));
                    }
                }
            }
        }

        return 0;
    }

    public static class Loc implements Comparable<Loc> {
        int x, y, lost;

        public Loc(int x, int y, int lost) {
            this.x = x;
            this.y = y;
            this.lost = lost;
        }

        @Override
        public int compareTo(Loc o) {
            return this.lost - o.lost;
        }
    }
}
