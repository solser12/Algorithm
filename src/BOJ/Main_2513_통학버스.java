package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2513_통학버스 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        PriorityQueue<Apartment> left = new PriorityQueue<>();
        PriorityQueue<Apartment> right = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            if (loc > S) {
                right.offer(new Apartment(loc - S, cnt));
            } else if (loc < S) {
                left.offer(new Apartment(S - loc, cnt));
            }
        }

        int ans = check(K, right) + check(K, left);

        System.out.println(ans);
        br.close();
    }

    public static int check(int K, PriorityQueue<Apartment> pq) {

        int result = 0, bus = 0, dist = 0;

        while (!pq.isEmpty()) {
            Apartment apartment = pq.poll();
            int temp = Math.min(K - bus, apartment.cnt);

            if (bus == 0) {
                dist = apartment.loc;
            }
            bus += temp;

            if (bus == K) {
                result += (dist * 2);
                bus = 0;
                dist = 0;
            }

            if (apartment.cnt > temp) {
                apartment.cnt -= temp;
                pq.offer(apartment);
            }
        }
        result += (dist * 2);

        return result;
    }

    public static class Apartment implements Comparable<Apartment> {
        int loc, cnt;

        public Apartment(int loc, int cnt) {
            this.loc = loc;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Apartment o) {
            return o.loc - this.loc;
        }
    }
}
