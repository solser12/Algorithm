package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253_좋다 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int find = arr[i];
            int left = 0, right = N - 1;
            if (left == i) left++;
            if (right == i) right--;

            while (left < right) {
                int calc = arr[left] + arr[right];
                if (find > calc) {
                    left++;
                } else if (find < calc) {
                    right--;
                } else {
                    ans++;
                    break;
                }

                if (left == i) left++;
                if (right == i) right--;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
