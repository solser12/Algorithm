package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13975_파일합치기3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long ans = 0;
            while (pq.size() > 1) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                ans += num1 + num2;
                pq.offer(num1 + num2);
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
