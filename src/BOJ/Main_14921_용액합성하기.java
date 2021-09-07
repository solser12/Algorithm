package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14921_용액합성하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N - 1;
        while (left < right) {
            int num = arr[left] + arr[right];

            if (Math.abs(ans) > Math.abs(num)) {
                ans = num;
            }

            if (num > 0) {
                right--;
            } else if (num < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
