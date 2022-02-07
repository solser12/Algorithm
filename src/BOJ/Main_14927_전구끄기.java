package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14927_전구끄기 {

    public static int N;
    public static int[] temp, bulbs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        bulbs = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0, index = 1;
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                index <<= 1;
                if (num == 1) {
                    sum |= index;
                }
            }
            bulbs[i] = sum;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= (1 << N) - 1; i++) {
            temp = bulbs.clone();
            ans = Math.min(check((i << 1)), ans);
        }

        System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));
        br.close();
    }

    public static int check(int start) {
        int count = 0, index = 1;
        for (int i = 1; i <= N; i++) {
            index <<= 1;
            if ((start & index) > 0) {
                press(1, index);
                count++;
            }
        }

        for (int i = 2; i <= N; i++) {
            index = 1;
            for (int j = 1; j <= N; j++) {
                index <<= 1;
                if ((temp[i - 1] & index) > 0) {
                    press(i, index);
                    count++;
                }
            }
        }

        temp[N] &= ~(1 + (2 << N));
        if (temp[N] > 0) return Integer.MAX_VALUE;
        return count;
    }

    public static void press(int x, int y) {
        temp[x - 1] ^= y;
        temp[x] ^= y + (y << 1) + (y >> 1);
        temp[x + 1] ^= y;
    }
}
