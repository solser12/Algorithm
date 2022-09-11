package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10610_30 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        boolean check = false;
        int sum = 0;
        for (char c : arr) {
            if (c == '0') {
                check = true;
            }
            sum += c - '0';
        }

        if (check && sum % 3 == 0) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == '0') {
                    cnt++;
                    continue;
                }
                sb.append(arr[i]);
            }
            for (int i = 0; i < cnt; i++) {
                sb.append('0');
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}
