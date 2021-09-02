package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2118_두개의탑 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        int leftTotal, rightTotal = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            rightTotal += arr[i];
        }
        rightTotal -= arr[0];
        leftTotal = arr[0];

        int left = 0, right = 1;
        while (left < N) {
            ans = Math.max(ans, Math.min(rightTotal, leftTotal));
            if (rightTotal < leftTotal) {
                leftTotal -= arr[left];
                rightTotal += arr[left++];
            } else if (rightTotal > leftTotal) {
                rightTotal -= arr[right];
                leftTotal += arr[right++];
                if (right >= N) right = 0;
            } else {
                ans = rightTotal;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
