package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 트럭 수
        int w = Integer.parseInt(st.nextToken());   // 다리 길이
        int L = Integer.parseInt(st.nextToken());   // 최대 하중

        Queue<Truck> bridge = new LinkedList<>();
        int total = 0;
        int time = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int truck = Integer.parseInt(st.nextToken());

            while (total + truck > L) {
                Truck t = bridge.poll();
                total -= t.weight;
                time = Math.max(t.time, time);
            }

            if (i == n - 1) {
                System.out.println(time + w);
                break;
            }

            bridge.offer(new Truck(time + w, truck));

            total += truck;
            time++;
        }

        br.close();
    }

    public static class Truck {
        int time, weight;

        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" +
                    "time=" + time +
                    ", weight=" + weight +
                    '}';
        }
    }
}
