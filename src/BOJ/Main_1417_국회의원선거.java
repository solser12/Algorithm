package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1417_국회의원선거 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        int dasomPick = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty() && pq.peek() >= dasomPick) {
            ans++;
            dasomPick++;
            pq.offer(pq.poll() - 1);
        }

        System.out.println(ans);
        br.close();
    }
}
