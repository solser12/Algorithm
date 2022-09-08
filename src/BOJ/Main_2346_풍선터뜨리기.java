package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2346_풍선터뜨리기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            deque.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;
        boolean way = true;
        while (!deque.isEmpty()) {
            if (way) {
                for (int i = 0; i < cnt - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < cnt; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }

            Balloon temp = deque.pollFirst();
            cnt = Math.abs(temp.num);
            way = temp.num > 0;
            sb.append(temp.index).append(' ');
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    public static class Balloon {

        int index, num;

        public Balloon(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
