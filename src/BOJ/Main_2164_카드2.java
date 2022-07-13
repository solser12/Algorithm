package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        boolean sw = false;
        while (q.size() > 1) {

            if (!sw) {
                q.poll();
            } else {
                q.offer(q.poll());
            }

            sw = !sw;
        }

        System.out.println(q.poll());
        br.close();
    }
}