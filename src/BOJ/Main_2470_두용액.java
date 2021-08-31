package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액 {

    static int N, ans1 = 0, ans2 = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        binarySearch();

        System.out.println(ans1 + " " + ans2);
        br.close();
    }

    public static void binarySearch() {
        int temp = Integer.MAX_VALUE;
        int left = 0, right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(temp) > Math.abs(sum)) {
                temp = sum;
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }
    }
}
