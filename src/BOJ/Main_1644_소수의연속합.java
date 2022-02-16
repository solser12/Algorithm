package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1644_소수의연속합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] notPrimeNumber = new boolean[N + 1];
        notPrimeNumber[0] = true;
        notPrimeNumber[1] = true;
        findPrimeNumber(notPrimeNumber);

        int ans = 0, sum = 0, left = 2;
        for (int right = 2; right <= N; right = nextNumber(notPrimeNumber, right)) {
            sum += right;
            while (left <= right) {
                if (sum > N) {
                    sum -= left;
                    left = nextNumber(notPrimeNumber, left);
                } else {
                    if (sum == N) ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static int nextNumber(boolean[] notPrimeNumber, int index) {
        int result = index + 1;
        while (result < notPrimeNumber.length) {
            if (!notPrimeNumber[result]) {
                return result;
            }
            result++;
        }
        return notPrimeNumber.length + 1;
    }

    public static void findPrimeNumber(boolean[] notPrimeNumber) {
        for (int i = 2; i < notPrimeNumber.length; i++) {
            if (notPrimeNumber[i]) continue;
            for (int j = i + i; j < notPrimeNumber.length; j += i) {
                notPrimeNumber[j] = true;
            }
        }
    }
}
