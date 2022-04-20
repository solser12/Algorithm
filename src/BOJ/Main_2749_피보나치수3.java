package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2749_피보나치수3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int fibo[] = new int[1500000];
        fibo[0] = 0;
        fibo[1] = 1;

        long n = Long.parseLong(br.readLine());
        for (int i = 2; i < 1500000; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
        }

        System.out.println(fibo[(int) (n % 1500000)]);
        br.close();
    }
}
