package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5671_호텔_방_번호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] check = init();

        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = N; i <= M; i++) {
                if (check[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean[] init() {
        boolean[] result = new boolean[5001];
        for (int i = 1; i <= 5000; i++) {
            if (check(i)) {
                result[i] = true;
            }
        }
        return result;
    }

    private static boolean check(int num) {
        boolean[] temp = new boolean[10];
        int digit = (int) Math.pow(10, (int)Math.log10(num));
        while (digit > 0) {
            int n = num / digit;
            if (temp[n]) {
                return false;
            }
            temp[n] = true;
            num %= digit;
            digit /= 10;
        }
        return true;
    }
}
