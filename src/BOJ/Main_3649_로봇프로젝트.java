package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3649_로봇프로젝트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";

        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            int front = 0, end = n - 1;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            while (front < end) {
                int sum = arr[front] + arr[end];
                if (sum > x) {
                    end--;
                } else if (sum < x) {
                    front++;
                } else {
                    sb.append("yes ").append(arr[front]).append(" ").append(arr[end]);
                    break;
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb);
            } else {
                System.out.println("danger");
            }

            sb.setLength(0);
            input = "";
        }

        br.close();
    }
}
