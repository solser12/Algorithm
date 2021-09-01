package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6137_문자열생성 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] ans = new char[N];
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        int idx = 0, left = 0, right = N - 1;
        while (left < right) {
            if (arr[left] < arr[right]) {
                ans[idx] = arr[left++];
            } else if (arr[left] > arr[right]) {
                ans[idx] = arr[right--];
            } else {
                int c = check(arr, left, right);
                if (c == 1) {
                    ans[idx] = arr[right--];
                } else {
                    ans[idx] = arr[left++];
                }
            }
            idx++;
        }
        ans[idx] = arr[left];

        for (int i = 1; i <= arr.length; i++) {
            sb.append(ans[i-1]);
            if (i % 80 == 0) sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int check(char[] arr, int left, int right) {
        int l = left + 1, r = right - 1;
        while (l < r) {
            if (arr[l] < arr[r]) {
                return -1;
            } else if (arr[l] > arr[r]) {
                return 1;
            } else {
                l++;
                r--;
            }
        }

        return 0;
    }
}
