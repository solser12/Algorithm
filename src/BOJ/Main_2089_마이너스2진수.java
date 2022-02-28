package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2089_마이너스2진수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            sb.append(0);
        } else {
            while (N != 0) {
                int num = Math.abs(N % -2);
                sb.append(num);
                if (num == 0) N /= -2;
                else N = (N - 1) / -2;
            }
        }

        System.out.println(sb.reverse());
        br.close();
    }
}
