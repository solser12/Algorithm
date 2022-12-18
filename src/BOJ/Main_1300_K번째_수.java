package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300_K번째_수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());

        long left = 1, right = N * N;
        while (left <= right) {
            long start = 0, end = 0;
            long mid = (left + right) / 2;

            for (long i = 1; i <= N; i++) {
                long max = i * N;
                if (max < mid) {
                    start += N;
                    end += N;
                } else {
                    long div = mid / i;
                    start += div;
                    end += div;

                    if (mid % i == 0) {
                        start--;
                    }
                }
            }

            if (start < K && end >= K) {
                System.out.println(mid);
                break;
            } else if (start >= K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        br.close();
    }
}
