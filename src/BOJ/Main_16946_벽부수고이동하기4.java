package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16946_벽부수고이동하기4 {

    public static int N, M;
    public static int[][] map, count;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        count = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 1) {
                    count[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : count) {
            for (int i : ints) {
                sb.append(i % 10);
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs(int x, int y) {

        HashSet<Loc> wall = new HashSet<>();
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        map[x][y] = 2;

        int cnt = 1;
        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy)) {
                    if (map[dx][dy] == 0) {
                        q.offer(new Loc(dx, dy));
                        map[dx][dy] = 2;
                        cnt++;
                    } else if (map[dx][dy] == 1) {
                        wall.add(new Loc(dx, dy));
                    }
                }
            }
        }

        for (Loc loc : wall) {
            count[loc.x][loc.y] += cnt;
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Loc loc = (Loc) o;

            if (x != loc.x) return false;
            return y == loc.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
