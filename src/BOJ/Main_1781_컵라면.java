package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1781_컵라면 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int time = Integer.MIN_VALUE;
        Question[] questions = new Question[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cupRamen = Integer.parseInt(st.nextToken());
            questions[i] = new Question(deadline, cupRamen);
            time = Math.max(time, deadline);
        }
        Arrays.sort(questions);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int index = 0;
        while (time != 0) {
            while (index < N && questions[index].deadline >= time) {
                pq.offer(questions[index].cupRamen);
                index++;
            }

            if (pq.isEmpty()) {
                if (index < N) {
                    time = questions[index].deadline;
                }
            } else {
                ans += pq.poll();
                time--;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Question implements Comparable<Question> {

        int deadline, cupRamen;

        public Question(int deadline, int cupRamen) {
            this.deadline = deadline;
            this.cupRamen = cupRamen;
        }

        @Override
        public int compareTo(Question o) {
            return o.deadline - this.deadline;
        }
    }
}
