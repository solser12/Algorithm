package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5214_환승 {

    public static int N, K, M;
    public static Station start;
    public static ArrayList<Station>[] transferStation;

    public static void main(String[] args) throws IOException {

        makeHipertube();
        System.out.println(bfs());
    }

    public static int bfs() {

        if (N == 1) return 1;
        PriorityQueue<Now> pq = new PriorityQueue<>();
        pq.offer(new Now(0, start));
        start.visited = 0;

        while (!pq.isEmpty()) {

            Now now = pq.poll();
            if (now.station.visited < now.hop) continue;
            if (now.station.num == N) return now.hop + 1;

            // 앞뒤
            if (now.station.prev != null) {
                if (now.station.prev.visited > now.hop) {
                    now.station.prev.visited = now.hop;
                    pq.offer(new Now(now.hop, now.station.prev));
                }
            }
            if (now.station.next != null) {
                if (now.station.next.visited > now.hop) {
                    now.station.next.visited = now.hop;
                    pq.offer(new Now(now.hop, now.station.next));
                }
            }

            // 환승 확인
            if (transferStation[now.station.num].size() > 1) {
                for (Station station : transferStation[now.station.num]) {
                    if (station.visited > now.hop + 1) {
                        station.visited = now.hop + 1;
                        pq.offer(new Now(now.hop + 1, station));
                    }
                }
                transferStation[now.station.num].clear();
            }
        }

        return -1;
    }

    public static void makeHipertube() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        transferStation = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            transferStation[i] = new ArrayList<>();
        }

        start = new Station(1, 0);
        transferStation[1].add(start);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            Station prev = null;
            for (int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());
                Station now = new Station(num, i);

                transferStation[num].add(now);

                if (prev != null) {
                    prev.next = now;
                    now.prev = prev;
                }

                prev = now;
            }
        }

        br.close();
    }

    public static class Now implements Comparable<Now> {
        int hop;
        Station station;

        public Now(int hop, Station station) {
            this.hop = hop;
            this.station = station;
        }

        @Override
        public int compareTo(Now o) {
            return this.hop - o.hop;
        }
    }

    public static class Station {
        int num, line, visited = Integer.MAX_VALUE;
        Station prev = null, next = null;

        public Station(int num, int line) {
            this.num = num;
            this.line = line;
        }
    }
}