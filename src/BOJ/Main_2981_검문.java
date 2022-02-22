package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2981_검문 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[2000];
        int left = 0, right = 1999;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int temp = arr[N - 1] - arr[N - 2];
        for (int i = N - 3; i >= 0; i--) {
            temp = gcb(temp, arr[i + 1] - arr[i]);
        }

        for (int i = 2; i * i < temp; i++) {
            if (temp % i == 0) {
                ans[left++] = i;
                ans[right--] = temp / i;
            }
        }

        for (int i = 0; i < left; i++) {
            sb.append(ans[i]).append(' ');
        }
        if (temp % (Math.sqrt(temp)) == 0) sb.append((int)Math.sqrt(temp)).append(' ');
        for (int i = right + 1; i < 2000; i++) {
            sb.append(ans[i]).append(' ');
        }
        sb.append(temp);

        System.out.println(sb);
        br.close();
    }

    public static int gcb(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
