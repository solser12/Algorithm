package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2662_기업투자 {

    static int[] dp;
    static int idx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] check = new int[500];

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            check[start] = end;
        }

        int index = 0;
        for (int i : check) {
            if (i != 0) {
                arr[index++] = i;
            }
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            if (i != 0) {
                if (dp[idx-1] < num) {
                    dp[idx++] = num;
                } else if (dp[idx-1] > num) {
                    dp[binarySearch(num)] = num;
                }
            } else {
                dp[idx++] = num;
            }
        }

        System.out.println(N - idx);
        br.close();
    }

    public static int binarySearch(int num) {
        int left = 0, right = idx - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (dp[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
