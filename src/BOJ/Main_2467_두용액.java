package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_두용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int check = Integer.MAX_VALUE;
        int front = 0, back = N - 1;
        int ans1 = 0, ans2 = 0;
        int sum;

        while (front != back) {

            sum = arr[front] + arr[back];

            if (Math.abs(check) > Math.abs(sum)) {
                check = sum;
                ans1 = arr[front];
                ans2 = arr[back];
            } else {
                if (sum > 0) {
                    back--;
                } else if (sum < 0) {
                    front++;
                } else {
                    ans1 = arr[front];
                    ans2 = arr[back];
                    break;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
        br.close();
    }
}
