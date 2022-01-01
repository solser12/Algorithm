package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1826_연료채우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        GasStation[] gasStations = new GasStation[N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());
            gasStations[i] = new GasStation(loc, quantity);
        }
        Arrays.sort(gasStations);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int village = Integer.parseInt(st.nextToken());
        int maxLen = Integer.parseInt(st.nextToken());
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (index < N && gasStations[index].loc <= maxLen) {
            pq.offer(gasStations[index++].quantity);
        }

        while (!pq.isEmpty() && maxLen < village) {
            int quantity = pq.poll();
            maxLen += quantity;
            ans++;
            while (index < N && gasStations[index].loc <= maxLen) {
                pq.offer(gasStations[index++].quantity);
            }
        }

        if (maxLen < village) ans = -1;
        System.out.println(ans);
        br.close();
    }

    public static class GasStation implements Comparable<GasStation> {
        int loc, quantity;

        public GasStation(int loc, int quantity) {
            this.loc = loc;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(GasStation o) {
            return this.loc - o.loc;
        }
    }
}
