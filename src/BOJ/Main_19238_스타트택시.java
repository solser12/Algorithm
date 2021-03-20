package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19238_스타트택시 {

    static int N, M, ans = -1;
    static int[][] map;
    static boolean[][] visited;
    static Taxi taxi;
    static Loc[] destination;
    static Queue<Loc> q = new LinkedList<>();
    static PriorityQueue<Qloc> pq = new PriorityQueue<>();
    static int[][] dt = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        // 택시 위치
        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(new Loc(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1), fuel);

        // 승객 위치
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int destX = Integer.parseInt(st.nextToken()) - 1;
            int destY = Integer.parseInt(st.nextToken()) - 1;
            // 목적지는 따로 저장
            destination[i] = new Loc(destX, destY);
            // 지도에 손님 위치 기록
            map[startX][startY] = i;

        }

        if (M == 0) ans = taxi.fuel;

        for (int i = 0; i < M; i++) {
            int first = findPassenger();
            System.out.println(taxi.fuel + "@");
            if (first == -1) break;
            int second = goDestination();
            System.out.println(taxi.fuel + "!" + second);
            if (second == -1) break;
            taxi.fuel += second;

            if (i == M - 1) ans = taxi.fuel;

            for (int[] a : map) {
                for(int b : a) {
                    System.out.print(b + "\t");
                }
                System.out.println();
            }
            System.out.println(taxi.fuel);
            System.out.println();
        }

        System.out.println(ans);
        br.close();
    }

    static int goDestination() {
        // 방문 초기화
        for (boolean[] v : visited) Arrays.fill(v, false);

        // 목적지
        Loc destLoc = destination[map[taxi.loc.x][taxi.loc.y]];
        map[taxi.loc.x][taxi.loc.y] = 0;

        if (taxi.loc.x == destLoc.x && taxi.loc.y == destLoc.y) return 0;

        // 큐에 시작점 넣기
        q.clear();
        q.add(taxi.loc);
        visited[taxi.loc.x][taxi.loc.y] = true;

        int fuel = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    // 갈 수 있는 곳인지 확인
                    if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy] && map[dx][dy] != -1) {
                        // 목적지 도착
                        if (dx == destLoc.x && dy == destLoc.y) {
                            taxi.loc.x = dx;
                            taxi.loc.y = dy;
                            if (taxi.fuel >= fuel) return fuel;
                            else return -1;
                        } else {
                            // 방문처리하고 큐에 넣기
                            visited[dx][dy] = true;
                            q.add(new Loc(dx, dy));
                        }
                    }
                }
            }
            fuel++;
        }
        return -1;
    }

    static int findPassenger() {
        // 방문 초기화
        for (boolean[] v : visited) Arrays.fill(v, false);

        if (map[taxi.loc.x][taxi.loc.y] > 0) return 0;

        // 큐에 시작점 넣기
        pq.clear();
        pq.add(new Qloc(taxi.loc, 0));
        visited[taxi.loc.x][taxi.loc.y] = true;

        int fuel = 1;
        while(!pq.isEmpty()) {
            int size = pq.size();
            for (int s = 0; s < size; s++) {
                Qloc qloc = pq.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = qloc.loc.x + dt[d][0];
                    int dy = qloc.loc.y + dt[d][1];
                    // 갈 수 있는 곳인지 확인
                    if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy] && map[dx][dy] != -1) {
                        // 그 곳에 손님이 있는지 확인
                        if (map[dx][dy] > 0) {  // 손님이 있으면
                            taxi.loc.x = dx;
                            taxi.loc.y = dy;
                            if (taxi.fuel > fuel) {
                                taxi.fuel -= fuel;
                                return fuel;
                            }
                            else return -1;
                        } else {    // 손님이 없으면
                            // 방문처리하고 큐에 넣기
                            visited[dx][dy] = true;
                            pq.add(new Qloc(new Loc(dx, dy), fuel + 1));
                        }
                    }
                }
            }
            fuel++;
        }
        return -1;
    }

    static class Taxi {
        Loc loc;
        int fuel;

        public Taxi(Loc loc, int fuel) {
            this.loc = loc;
            this.fuel = fuel;
        }
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Qloc implements Comparable<Qloc> {
        Loc loc;
        int fuel;

        public Qloc(Loc loc, int fuel) {
            this.loc = loc;
            this.fuel = fuel;
        }


        @Override
        public int compareTo(Qloc o) {
            if (this.fuel == o.fuel) {
                if (this.loc.x == o.loc.x) {
                    return this.loc.y - o.loc.y;
                }
                return this.loc.x - o.loc.x;
            }
            return this.fuel - o.fuel;
        }
    }
}
