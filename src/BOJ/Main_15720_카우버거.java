package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15720_카우버거 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> burger = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> side = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> drink = new PriorityQueue<>(Collections.reverseOrder());

        int totalSum = 0;
        if (B > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                int price = Integer.parseInt(st.nextToken());
                totalSum += price;
                burger.offer(price);
            }
        }
        if (C > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < C; i++) {
                int price = Integer.parseInt(st.nextToken());
                totalSum += price;
                side.offer(price);
            }
        }
        if (D > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < D; i++) {
                int price = Integer.parseInt(st.nextToken());
                totalSum += price;
                drink.offer(price);
            }
        }

        int ans = 0;
        for (int i = 0; i < Math.max(Math.max(B, C), D); i++) {
            boolean isSale = true;
            int sum = 0;

            if (burger.isEmpty()) {
                isSale = false;
            } else {
                sum += burger.poll();
            }

            if (side.isEmpty()) {
                isSale = false;
            } else {
                sum += side.poll();
            }

            if (drink.isEmpty()) {
                isSale = false;
            } else {
                sum += drink.poll();
            }

            if (isSale) {
                sum *= 0.9;
            }
            ans += sum;
        }

        System.out.println(totalSum);
        System.out.println(ans);
        br.close();
    }
}
