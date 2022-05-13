package Programmers;

import java.util.PriorityQueue;

public class 더맵게 {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        int count = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                return count;
            }
            count++;
            pq.offer(pq.poll() + (pq.poll() * 2));
        }

        return pq.peek() >= K ? count : -1;
    }
}