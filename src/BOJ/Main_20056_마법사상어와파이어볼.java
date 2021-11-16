package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_20056_마법사상어와파이어볼 {

    public static int N, M, K;
    public static int[][] dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static Queue<FireBall> fireBalls = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.offer(new FireBall(new Loc(r, c), m, s, d));
        }

        System.out.println(start());

        br.close();
    }

    public static int start() {

        ArrayList<Log> logs = new ArrayList<>();
        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int k = 0; k < K; k++) {
            // 파이어볼 이동
            while (!fireBalls.isEmpty()) {
                FireBall fireBall = fireBalls.poll();
                Loc loc = fireBall.move();
                if (visited[loc.x][loc.y] == -1) {
                    visited[loc.x][loc.y] = logs.size();
                    Log log = new Log(loc, fireBall.d);
                    log.add(fireBall.m, fireBall.s, fireBall.d);
                    logs.add(log);
                } else {
                    logs.get(visited[loc.x][loc.y]).add(fireBall.m, fireBall.s, fireBall.d);
                }
            }

            // 파이어볼 확인
            for (Log log : logs) {
                visited[log.loc.x][log.loc.y] = -1;
                log.division();
            }

            logs.clear();

            if (fireBalls.isEmpty()) return 0;
        }

        int result = 0;
        for (FireBall fireBall : fireBalls) {
            result += fireBall.m;
        }
        return result;
    }

    public static class Log {
        Loc loc;
        int count, m, s, d, odd;

        public Log(Loc loc, int d) {
            this.loc = loc;
            this.d = d;
            this.count = 0;
            this.m = 0;
            this.s = 0;
            this.odd = 0;
        }

        public void add(int m, int s, int d) {
            count++;
            this.m += m;
            this.s += s;
            if (d % 2 == 1) odd++;
        }

        public void division() {
            if (count == 1) {
                fireBalls.offer(new FireBall(loc, m, s, d));
            } else {
                int newM = m / 5;
                if (newM == 0) return;

                int newS = s / count;
                for (int start = (odd == count || odd == 0) ? 0 : 1; start < 8; start += 2) {
                    fireBalls.offer(new FireBall(loc, newM, newS, start));
                }
            }
        }
    }

    public static class FireBall {
        Loc loc;
        int m, s, d;    // 질량, 속력, 방향

        public FireBall(Loc loc, int m, int s, int d) {
            this.loc = loc;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public Loc move() {
            int dx = loc.x, dy = loc.y;
            if (dt[d][0] == 1) {
                dx = (dx + s) % N;
            } else if (dt[d][0] == -1) {
                dx = (dx + N - (s % N)) % N;
            }

            if (dt[d][1] == 1) {
                dy = (dy + s) % N;
            } else if (dt[d][1] == -1) {
                dy = (dy + N - (s % N)) % N;
            }

            return new Loc(dx, dy);
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
