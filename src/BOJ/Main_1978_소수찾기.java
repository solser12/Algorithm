package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[1001];
        make(prime);
        prime[0] = true;
        prime[1] = true;
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (!prime[Integer.parseInt(st.nextToken())]) count++;
        }

        System.out.println(count);
        br.close();
    }

    public static void make(boolean[] prime) {
        for (int i = 2; i <= 1000; i++) {
            if (!prime[i]) {
                for (int j = i; j * i <= 1000; j++) {
                    prime[j * i] = true;
                }
            }
        }
    }
}
