package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long ans1 = 0, ans2 = 0, ans3 = 0;
        long check = Long.MAX_VALUE, sum;
        int front, back, middle;
        for (int i = 1; i < N - 1; i++) {
            front = 0;
            back = N - 1;
            middle = i;

            while (true) {
                sum = arr[front] + arr[middle] + arr[back];
                if (Math.abs(check) > Math.abs(sum)) {
                    ans1 = arr[front];
                    ans2 = arr[middle];
                    ans3 = arr[back];
                    check = sum;
                    if (sum == 0) {
                        i = N;
                        break;
                    }
                }

                if (sum > 0) {
                    back--;
                } else if (sum < 0) {
                    front++;
                }

                if (front == middle || middle == back) break;
            }
        }

        sb.append(ans1).append(' ').append(ans2).append(' ').append(ans3);
        System.out.println(sb);
        br.close();
    }
}