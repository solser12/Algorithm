package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19598_최소회의실개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Course[] courses = new Course[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            courses[i] = new Course(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(courses);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(courses[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= courses[i].start) {
                pq.poll();
            }
            pq.offer(courses[i].end);
        }

        System.out.println(pq.size());
        br.close();
    }

    public static class Course implements Comparable<Course> {
        int start, end;

        public Course(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Course o) {
            return this.start - o.start;
        }
    }
}
