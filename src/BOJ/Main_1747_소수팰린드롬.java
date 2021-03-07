package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1747_소수팰린드롬 {

    public static void main(String[] args) throws IOException {

        final int MAX_NUM = 1003002;
        final int MAX_SQRT = (int) Math.sqrt(MAX_NUM);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] eratosthenes = new boolean[MAX_NUM];

        eratosthenes[1] = true;
        for (int i = 2; i <= MAX_SQRT; i++) {
            if (eratosthenes[i]) continue;
            for (int j = i + i; j < MAX_NUM; j += i) {
                eratosthenes[j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int front, back, ans = 0;
        boolean flag;

        for (int i = N; i <= MAX_NUM; i++) {
            if (eratosthenes[i]) continue;
            String s = Integer.toString(i);
            front = 0;
            back = s.length()-1;
            flag = true;
            while(front < back) {
                if (s.charAt(front++) != s.charAt(back--)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
