package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_8980_택배 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 마을 수
        int C = Integer.parseInt(st.nextToken());   // 트럭 용량
        int M = Integer.parseInt(br.readLine());    // 정보 갯수

        int[] sum = new int[N];
        Arrays.fill(sum, C);

        int ans = 0;
        PriorityQueue<Order> order = new PriorityQueue<>();
        ArrayList<Integer> zero = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            order.add(new Order(start, end, weight));
        }

        while (!order.isEmpty()) {
            Order thing = order.poll();
            boolean isPossible = true;
            int min = thing.weight;

            for (int i : zero) {
                if (thing.start <= i && thing.end > i) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int i = thing.start; i < thing.end; i++) {
                    min = Math.min(min, sum[i]);
                }

                for (int i = thing.start; i < thing.end; i++) {
                    sum[i] -= min;
                    if (sum[i] == 0) {
                        zero.add(i);
                    }
                }

                ans += min;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Order implements Comparable<Order> {
        int start, end, weight;

        public Order(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Order o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}