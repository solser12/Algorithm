package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16496_큰수만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr, (o1, o2) -> {
            BigDecimal a = new BigDecimal(o1 + o2);
            BigDecimal b = new BigDecimal(o2 + o1);
            return b.compareTo(a);
        });

        StringBuilder sb = new StringBuilder();
        if (arr[0].equals("0")) {
            sb.append(0);
        } else {
            for (String s : arr) {
                sb.append(s);
            }
        }

        System.out.println(sb);
        br.close();
    }
}