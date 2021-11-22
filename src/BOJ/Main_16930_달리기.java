package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16930_달리기 {

    public static int N, M, K, ans = -1;
    public static char[][] gym;
    public static int[][] visited;
    public static Loc destination;
    public static int[][] dt = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gym = new char[N][];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            gym[i] = br.readLine().toCharArray();
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        Loc start = new Loc(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
        destination = new Loc(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        bfs(start);

        System.out.println(ans);
        br.close();
    }

    public static void bfs(Loc start) {
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        visited[start.x][start.y] = 0;
        pq.offer(start);

        while (!pq.isEmpty()) {
            Loc loc = pq.poll();
            if (destination.isSame(loc)) {
                ans = loc.time;
                return;
            } else if (visited[loc.x][loc.y] < loc.time) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int dx = loc.x;
                int dy = loc.y;
                for (int k = 0; k < K; k++) {
                    dx += dt[d][0];
                    dy += dt[d][1];

                    if (!check(dx, dy) || visited[dx][dy] < loc.time + 1) break;

                    if (visited[dx][dy] == Integer.MAX_VALUE) {
                        visited[dx][dy] = loc.time + 1;
                        pq.offer(new Loc(dx, dy, loc.time + 1));
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && gym[x][y] == '.';
    }

    public static class Loc implements Comparable<Loc> {
        int x, y, time;

        public Loc(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean isSame(Loc loc) {
            return this.x == loc.x && this.y == loc.y;
        }


        @Override
        public int compareTo(Loc o) {
            return this.time - o.time;
        }
    }
}
