package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9020_골드바흐의추측 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] primeNumber = init();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            int left = num / 2;
            int right = num / 2;

            while (true) {
                if (!primeNumber[left] && !primeNumber[right]) {
                    sb.append(left).append(' ').append(right).append('\n');
                    break;
                }
                left--;
                right++;
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean[] init() {
        boolean[] check = new boolean[10001];

        for (int i = 2; i <= 10000; i++) {
            if (check[i]) continue;
            for (int j = i + i; j <= 10000; j += i) {
                check[j] = true;
            }
        }

        return check;
    }
}
