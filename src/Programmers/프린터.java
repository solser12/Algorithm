package Programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터 {

    public int solution(int[] priorities, int location) {

        PriorityQueue<Integer> weight = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Request> printerQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            weight.offer(priorities[i]);
            printerQueue.offer(new Request(i, priorities[i]));
        }

        int count = 1;
        while (true) {

            int w = weight.poll();
            while (w != printerQueue.peek().weight) {
                printerQueue.offer(printerQueue.poll());
            }

            if (printerQueue.poll().location == location) {
                break;
            }

            count++;
        }

        return count;
    }

    public class Request {

        int location, weight;

        public Request(int location, int weight) {
            this.location = location;
            this.weight = weight;
        }
    }
}
