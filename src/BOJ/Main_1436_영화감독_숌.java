package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독_숌 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = init();

        System.out.println(arr[N - 1]);
        br.close();
    }

    public static int[] init() {
        int[] result = new int[10000];
        int index = 0;
        for (int i = 666; i < Integer.MAX_VALUE; i++) {
            if (check(i)) {
                result[index++] = i;
            }
            if (index == 10000) {
                break;
            }
        }
        return result;
    }

    public static boolean check(int num) {
        int digit = (int) Math.pow(10, (int)Math.log10(num));
        int cnt = 0;
        while (digit > 0) {
            if (num / digit == 6) {
                cnt++;
                if (cnt == 3) {
                    return true;
                }
            } else {
                cnt = 0;
            }
            num %= digit;
            digit /= 10;
        }
        return false;
    }
}
