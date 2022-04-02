package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2457_공주님의정원 {

    public static int[] maxDay;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        int open = dayToInt(3, 1);
        int close = dayToInt(12, 1);

        PriorityQueue<Flower> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int openDay = dayToInt(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int closeDay = dayToInt(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (closeDay < open || close < openDay) {
                continue;
            }

            if (openDay < open) {
                openDay = open;
            }

            if (close < closeDay) {
                closeDay = close;
            }

            pq.offer(new Flower(openDay, closeDay));
        }

        int ans = 0;
        int nowClose = dayToInt(3, 1), tempClose;
        while (!pq.isEmpty() && !(nowClose == close)) {
            tempClose = 0;
            while (!pq.isEmpty() && pq.peek().open <= nowClose) {
                Flower temp = pq.poll();
                tempClose = Math.max(tempClose, temp.close);
            }

            if (tempClose == 0) {
                break;
            }

            nowClose = tempClose;
            ans++;
        }

        if (nowClose != close) {
            ans = 0;
        }

        System.out.println(ans);
        br.close();
    }

    public static void init() {
        maxDay = new int[13];
        maxDay[2] = 31;
        maxDay[3] = maxDay[2] + 28;
        maxDay[4] = maxDay[3] + 31;
        maxDay[5] = maxDay[4] + 30;
        maxDay[6] = maxDay[5] + 31;
        maxDay[7] = maxDay[6] + 30;
        maxDay[8] = maxDay[7] + 31;
        maxDay[9] = maxDay[8] + 31;
        maxDay[10] = maxDay[9] + 30;
        maxDay[11] = maxDay[10] + 31;
        maxDay[12] = maxDay[11] + 30;
    }

    public static int dayToInt(int month, int day) {
        return maxDay[month] + day;
    }

    public static class Flower implements Comparable<Flower> {
        int open, close;

        public Flower(int open, int close) {
            this.open = open;
            this.close = close;
        }

        @Override
        public int compareTo(Flower o) {
            return this.open - o.open;
        }
    }
}
