package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15954_인형들 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        double ans = Double.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = i + K - 1; j <= N; j++) {
                double avg = (sum[j] - sum[i - 1]) / (double) (j - i + 1);
                double temp = 0;
                for (int k = i; k <= j; k++) {
                    temp += square(arr[k] - avg);
                }
                ans = Math.min(ans, Math.sqrt(temp / (j - i + 1)));
            }
        }

        System.out.printf("%.11f%n", ans);
        br.close();
    }

    public static double square(double num) {
        return num * num;
    }
}
