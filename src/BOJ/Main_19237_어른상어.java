package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19237_어른상어 {

    public static int N, M, K;
    public static int[][] map, now;
    public static Queue<Smell> smell = new LinkedList<>();
    public static Shark[] sharks;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        now = new int[N][N];
        sharks = new Shark[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(map[i], -1);
            Arrays.fill(now[i], -1);
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                if (num >= 0) {
                    sharks[num] = new Shark(new Loc(i, j), num);
                    map[i][j] = num;
                    now[i][j] = num;
                    smell.add(new Smell(new Loc(i, j), K));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sharks[i].way = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    sharks[i].priority[j][k] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        System.out.println(start());

        br.close();
    }

    public static int start() {

        for (int time = 1; time <= 1000; time++) {
            // 상어 이동
            for (int s = M - 1; s >= 0; s--) {
                if (sharks[s] == null) continue;
                sharks[s].move();
            }

            // 상어 냄새 채우기
            int count = 0;
            for (int s = 0; s < M; s++) {
                if (sharks[s] == null) continue;
                count++;
                if (map[sharks[s].loc.x][sharks[s].loc.y] < 0) {
                    map[sharks[s].loc.x][sharks[s].loc.y] = sharks[s].num;
                } else {
                    map[sharks[s].loc.x][sharks[s].loc.y] += M;
                }
                smell.offer(new Smell(new Loc(sharks[s].loc.x, sharks[s].loc.y), time + K));
            }

            if (count == 1) {
                return time;
            }

            // 냄새 지우기
            while (!smell.isEmpty() && smell.peek().time <= time) {
                Loc loc = smell.poll().loc;
                map[loc.x][loc.y] -= M;
            }
        }

        return -1;
    }

    public static class Shark {
        Loc loc;
        int num, way;
        int[][] priority = new int[4][4];

        public Shark(Loc loc, int num) {
            this.loc = loc;
            this.num = num;
        }

        public void move() {
            // 빈 공간 찾기
            for (int i = 0; i < 4; i++) {
                int dx = loc.x + dt[priority[way][i]][0];
                int dy = loc.y + dt[priority[way][i]][1];
                if (check(dx, dy) && map[dx][dy] < 0) {
                    now[loc.x][loc.y] = -1;
                    if (now[dx][dy] != -1) {
                        sharks[now[dx][dy]] = null;
                    }
                    now[dx][dy] = this.num;
                    loc.x = dx;
                    loc.y = dy;
                    way = priority[way][i];
                    return;
                }
            }

            // 내 냄새로 가기
            for (int i = 0; i < 4; i++) {
                int dx = loc.x + dt[priority[way][i]][0];
                int dy = loc.y + dt[priority[way][i]][1];
                if (check(dx, dy) && map[dx][dy] % M == num) {
                    now[loc.x][loc.y] = -1;
                    now[dx][dy] = this.num;
                    loc.x = dx;
                    loc.y = dy;
                    way = priority[way][i];
                    return;
                }
            }
        }
    }

    public static class Smell {
        Loc loc;
        int time;

        public Smell(Loc loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
