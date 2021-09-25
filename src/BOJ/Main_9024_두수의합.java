package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9024_두수의합 {

    static int n, k, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T  = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            ans = 0;
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int minValue = Integer.MAX_VALUE;
            int left = 0, right = n - 1;
            while (left < right) {
                int calc = arr[left] + arr[right];

                if (calc < k) {
                    left++;
                } else if (calc > k) {
                    int abs = Math.abs(k - calc);
                    minValue = Math.min(minValue, abs);
                    right--;
                } else {
                    minValue = 0;
                    break;
                }
            }

            left = 0;
            right = n - 1;
            while (left < right && minValue != 0) {
                int calc = arr[left] + arr[right];

                if (calc > k) {
                    right--;
                } else if (calc < k) {
                    int abs = Math.abs(k - calc);
                    minValue = Math.min(minValue, abs);
                    left++;
                } else {
                    minValue = 0;
                    break;
                }
            }

            int sum = find(k + minValue) + find(k - minValue);
            if (minValue == 0) sum /= 2;

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int find(int num) {
        int cnt = 0, left = 0, right = n - 1;
        while (left < right) {
            int temp = arr[left] + arr[right];

            if (temp == num) {
                cnt++;
                left++;
                right--;
            } else if (temp > num) {
                right--;
            } else {
                left++;
            }
        }

        return cnt;
    }
}
