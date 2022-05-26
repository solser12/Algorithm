package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {

        boolean[] join = new boolean[n + 2];
        Arrays.fill(join, true);

        for (int i : lost) {
            join[i] = false;
        }

        int ans = n - lost.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : reserve) {
            if (!join[i]) {
                join[i] = true;
                ans++;
            } else {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int student = pq.poll();
            if (!join[student - 1]) {
                ans++;
            } else if (!join[student + 1]) {
                ans++;
                join[student + 1] = true;
            }
        }

        return ans;
    }
}
