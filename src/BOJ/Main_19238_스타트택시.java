package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19238_스타트택시 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static  LocAndFuel taxi;
    static Loc[] destination;
    static Queue<Loc> q = new LinkedList<>();
    static Queue<LocAndFuel> pq = new PriorityQueue<>();
    static int[][] dt = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = -2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        destination = new Loc[M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) input = -1;
                map[i][j] = input;
            }
        }

        st = new StringTokenizer(br.readLine());
        Loc loc = new Loc(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        taxi = new LocAndFuel(loc, fuel);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;

            // 승객 시작 위치
            map[startX][startY] = i;
            destination[i] = new Loc(endX, endY);
        }

        for (int i = 0; i < M; i++) {
            int dest = findPassenger();
            if (dest == -1 || !goDestination(dest)) {
                ans = -1;
                break;
            }
//            for (int[] a : map) {
//                for (int b : a) {
//                    System.out.print(b + "\t");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        if (ans == -2) ans = taxi.fuel;

        System.out.println(ans);
        br.close();
    }

    static boolean goDestination(int dest) {
        // 방문 초기화
        for (int i = 0; i  < N; i++) Arrays.fill(visited[i], false);

        // 택시 방문기록 처리
        q.clear();
        q.add(taxi.loc);
        visited[taxi.loc.x][taxi.loc.y] = true;

        int fuel = 1;
        while (!q.isEmpty()) {
            // 기름 떨어졌는지 확인
            if (fuel > taxi.fuel) {
                break;
            }
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] != -1 && !visited[dx][dy]) {
                        // 목적지인지 확인
                        if (dx == destination[dest].x && dy == destination[dest].y) {
                            taxi.loc.x = dx;
                            taxi.loc.y = dy;
                            taxi.fuel += fuel;
                            return true;
                        } else {
                            q.add(new Loc(dx,dy));
                            visited[dx][dy] = true;
                        }
                    }
                }
            }

            fuel++;
        }

        return false;
    }

    static int findPassenger() {
        // 방문 초기화
        for (int i = 0; i  < N; i++) Arrays.fill(visited[i], false);

        // 택시 방문기록 처리
        pq.clear();
        pq.add(new LocAndFuel(taxi.loc, 0));
        visited[taxi.loc.x][taxi.loc.y] = true;

        while (!pq.isEmpty()) {
            LocAndFuel locAndFuel = pq.poll();
            // 기름 떨어졌는지 확인
            if (locAndFuel.fuel >= taxi.fuel) {
                break;
            }

            // 지금 위치에 승객이 있는지 확인
            if (map[locAndFuel.loc.x][locAndFuel.loc.y] > 0) {
                int result = map[locAndFuel.loc.x][locAndFuel.loc.y];
                taxi.loc = locAndFuel.loc;
                taxi.fuel -= locAndFuel.fuel;
                map[locAndFuel.loc.x][locAndFuel.loc.y] = 0;
                return result;
            }

            for (int d = 0; d < 4; d++) {
                int dx = locAndFuel.loc.x + dt[d][0];
                int dy = locAndFuel.loc.y + dt[d][1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] != -1 && !visited[dx][dy]) {
                    pq.add(new LocAndFuel(new Loc(dx, dy), locAndFuel.fuel + 1));
                    visited[dx][dy] = true;
                }
            }
        }

        return -1;
    }

    static class LocAndFuel implements Comparable<LocAndFuel> {
        Loc loc;
        int fuel;

        public LocAndFuel(Loc loc, int fuel) {
            this.loc = loc;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(LocAndFuel o) {
            if (this.fuel == o.fuel) {
                if (this.loc.x == o.loc.x)  {
                    return this.loc.y - o.loc.y;
                }
                return this.loc.x - o.loc.x;
            }
            return this.fuel - o.fuel;
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
