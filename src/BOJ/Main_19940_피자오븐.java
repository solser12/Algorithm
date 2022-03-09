package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main_19940_피자오븐 {

    public final static int ADDH = 10000;
    public final static int ADDT = 1000;
    public final static int MINT = 100;
    public final static int ADDO = 10;
    public final static int MINO = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            // 36 ~ (60) + 35
            int hourCount = N / 60;
            int mod = N % 60;

            int end;
            if (mod >= 36) {
                hourCount++;
                end = -(60 - mod);
            } else {
                end = mod;
            }

            int result = bfs(end, hourCount);
            int div = 10000;
            for (int i = 0; i < 5; i++) {
                sb.append(result / div).append(' ');
                result %= div;
                div /= 10;
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(int end, int hourCount) {

        int result = 0;
        PriorityQueue<Time> pq = new PriorityQueue<>();
        pq.offer(new Time(0, hourCount, hourCount * ADDH));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!pq.isEmpty()) {
            Time time = pq.poll();
            if (time.minute == end) {
                result = time.buttonCount;
                break;
            }

            if (!visited.contains(time.buttonCount + MINO) && check(time.minute - 1)) {
                visited.add(time.buttonCount + MINO);
                pq.offer(new Time(time.minute - 1, time.totalCount + 1, time.buttonCount + MINO));
            }

            if (!visited.contains(time.buttonCount + ADDO) && check(time.minute + 1)) {
                visited.add(time.buttonCount + ADDO);
                pq.offer(new Time(time.minute + 1, time.totalCount + 1, time.buttonCount + ADDO));
            }

            if (!visited.contains(time.buttonCount + MINT) && check(time.minute - 10)) {
                visited.add(time.buttonCount + MINT);
                pq.offer(new Time(time.minute - 10, time.totalCount + 1, time.buttonCount + MINT));
            }

            if (!visited.contains(time.buttonCount + ADDT) && check(time.minute + 10)) {
                visited.add(time.buttonCount + ADDT);
                pq.offer(new Time(time.minute + 10, time.totalCount + 1, time.buttonCount + ADDT));
            }
        }

        return result;
    }

    public static boolean check(int time) {
        return -24 <= time && time <= 35;
    }

    public static class Time implements Comparable<Time> {

        int minute, totalCount, buttonCount;

        public Time(int minute, int totalCount, int buttonCount) {
            this.minute = minute;
            this.totalCount = totalCount;
            this.buttonCount = buttonCount;
        }

        @Override
        public int compareTo(Time o) {
            if (this.totalCount == o.totalCount) {
                return this.buttonCount - o.buttonCount;
            }
            return this.totalCount - o.totalCount;
        }
    }
}
