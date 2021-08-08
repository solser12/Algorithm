package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10800_컬러볼 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Ball[] balls = new Ball[N];
        int[] ans = new int[N];
        int maxColor = 0;
        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            maxColor = Math.max(color, maxColor);
            maxSize = Math.max(size, maxSize);
            balls[i] = new Ball(color, size, i);
        }

        Arrays.sort(balls);
        int totalSum = 0, pastSum = 0;
        int lastColor = 0, lastSize = 0;
        int[] colorSum = new int[maxColor + 1];

        for (int i = 0; i < N; i++) {
            Ball ball = balls[i];

            if (lastSize < ball.size) {
                totalSum = pastSum;
            }

            if (lastSize == ball.size && lastColor == ball.color) {
                ans[ball.idx] = ans[balls[i - 1].idx];
            } else {
                ans[ball.idx] = totalSum - colorSum[ball.color];
            }

            pastSum += ball.size;
            colorSum[ball.color] += ball.size;

            lastColor = ball.color;
            lastSize = ball.size;
        }


        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Ball implements Comparable<Ball> {
        int color, size, idx;

        public Ball(int color, int size, int idx) {
            this.color = color;
            this.size = size;
            this.idx = idx;
        }

        @Override
        public int compareTo(Ball o) {
            if (this.size == o.size) {
                return this.color - o.color;
            }
            return this.size - o.size;
        }
    }
}
