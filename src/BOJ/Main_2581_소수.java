package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2581_소수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] primeNumber = makePrimeNumber(N + 1);

        int minNum = -1, sum = 0;
        for (int i = N; i >= M; i--) {
            if (!primeNumber[i]) {
                sum += i;
                minNum = i;
            }
        }

        if (minNum == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minNum);
        }

        br.close();
    }

    public static boolean[] makePrimeNumber(int N) {
        boolean[] primeNumber = new boolean[N];
        primeNumber[0] = true;
        primeNumber[1] = true;
        for (int i = 2; i < N; i++) {
            if (primeNumber[i]) continue;
            for (int j = i + i; j < N; j += i) {
                primeNumber[j] = true;
            }
        }
        return primeNumber;
    }
}
