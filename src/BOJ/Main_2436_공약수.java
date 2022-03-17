package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2436_공약수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());
        int div = lcm / gcd;

        int max = 0, min = 0;
        for (int i = 1; i * i <= div; i++) {
            if (div % i == 0 && gcd(div / i, i) == 1) {
                min = i;
                max = div / i;
            }
        }
        max *= gcd;
        min *= gcd;

        System.out.println(min + " " + max);
        br.close();
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
