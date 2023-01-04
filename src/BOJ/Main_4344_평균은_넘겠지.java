package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344_평균은_넘겠지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            double sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            double cnt = 0;
            double avg = sum / N;
            for (int i : arr) {
                if (i > avg) {
                    cnt++;
                }
            }
            System.out.printf("%.3f%%\n", cnt / N * 100);
        }

        br.close();
    }
}