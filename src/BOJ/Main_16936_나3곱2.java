package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16936_나3곱2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, (num1, num2) -> {
            int divCount1 = divCount(num1);
            int divCount2 = divCount(num2);
            if (divCount1 == divCount2) {
                return num1.compareTo(num2);
            }
            return divCount2 - divCount1;
        });

        StringBuilder sb = new StringBuilder();
        for (long num : arr) {
            sb.append(num).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    public static int divCount(long num) {
        long divNum = num;
        int result = 0;
        while (true) {
            if (divNum % 3 > 0) break;
            result++;
            divNum /= 3;
        }

        return result;
    }
}
