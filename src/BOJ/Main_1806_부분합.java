package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        int ans = Integer.MAX_VALUE;
        int front = 0, back = 0;
        int sum = arr[0];
        while (front <= back) {
            if (sum >= S) {
                int len = back - front + 1;
                ans = Math.min(ans, len);
                sum -= arr[front];
                front++;
            } else {
                back++;
                if (back >= N) break;
                sum += arr[back];
            }
        }

        System.out.println(ans != Integer.MAX_VALUE ? ans : 0);

        br.close();
    }
}
