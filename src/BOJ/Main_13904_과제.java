package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13904_과제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Homework[] homework = new Homework[N];
        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            homework[i] = new Homework(deadLine, weight);

            maxDay = Math.max(maxDay, deadLine);
        }
        Arrays.sort(homework);

        int ans = 0, index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = maxDay; i >= 1; i--) {
            while (index < N && homework[index].deadline >= i) {
                pq.offer(homework[index++].weight);
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
        br.close();
    }
    
    public static class Homework implements Comparable<Homework> {
        int deadline, weight;

        public Homework(int deadline, int weight) {
            this.deadline = deadline;
            this.weight = weight;
        }

        @Override
        public int compareTo(Homework o) {
            return o.deadline - this.deadline;
        }
    }
}
