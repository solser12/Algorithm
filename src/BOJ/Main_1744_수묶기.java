package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1744_수묶기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int EMPTY = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int ans = 0, leftIndex = 0, temp = EMPTY;
        while (leftIndex < N && arr[leftIndex] <= 0) {
            if (temp == EMPTY) {
                temp = arr[leftIndex];
            } else {
                ans += temp * arr[leftIndex];
                temp = EMPTY;
            }
            leftIndex++;
        }

        if (temp != EMPTY) {
            ans += temp;
            temp = EMPTY;
        }

        int rightIndex = N - 1;
        while (rightIndex >= leftIndex) {
            if (temp == EMPTY) {
                temp = arr[rightIndex];
            } else {
                if (arr[rightIndex] == 1) {
                    ans += temp + arr[rightIndex];
                } else {
                    ans += temp * arr[rightIndex];
                }
                temp = EMPTY;
            }
            rightIndex--;
        }

        if (temp != EMPTY) {
            ans += temp;
        }

        System.out.println(ans);
        br.close();
    }
}
