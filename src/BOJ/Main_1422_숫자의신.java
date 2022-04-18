package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1422_숫자의신 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long maxNum = 0;
        String[] arr = new String[K];
        for (int i = 0; i < K; i++) {
            arr[i] = br.readLine();
            maxNum = Math.max(maxNum, Long.parseLong(arr[i]));
        }
        Arrays.sort(arr, (o1, o2) -> {
            BigDecimal a = new BigDecimal(o1 + o2);
            BigDecimal b = new BigDecimal(o2 + o1);
            return b.compareTo(a);
        });

        boolean isRepeat = false;
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (!isRepeat && Long.parseLong(s) == maxNum) {
                sb.append(String.valueOf(maxNum).repeat(Math.max(0, N - K + 1)));
                isRepeat = true;
            } else {
                sb.append(s);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
