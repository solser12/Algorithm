package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2014_소수의곱 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        long[] prime = new long[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            prime[i] = Integer.parseInt(st.nextToken());
            pq.offer(prime[i]);
        }

        for (int i = 1; i < N; i++) {
            long num = pq.poll();
            for (long p : prime) {
                long mul = num * p;

                if (mul > Integer.MAX_VALUE) {
                    break;
                }
                pq.offer(mul);

                if (num % p == 0) {
                    break;
                }
            }
        }

        System.out.println(pq.poll());
        br.close();
    }
}
