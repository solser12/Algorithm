package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14939_불끄기 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] bulbs = new int[12];
        for (int i = 1; i <= 10; i++) {
            String input = br.readLine();
            int num = 0, index = 2;
            for (int j = 1; j <= 10; j++) {
                char c = input.charAt(j - 1);
                if (c == 'O') {
                    num |= index;
                }
                index <<= 1;
            }
            bulbs[i] = num;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1024; i++) {
            int[] temp = bulbs.clone();
            ans = Math.min(ans, check(temp, (i << 1)));
        }

        System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));
        br.close();
    }

    public static int check(int[] bulbs, int visited) {
        int count = 0, num = 1;
        for (int i = 1; i <= 10; i++) {
            num <<= 1;
            if ((visited & num) > 0) {
                change(bulbs, 1, num);
                count++;
            }
        }

        for (int i = 2; i <= 10; i++) {
            num = 1;
            for (int j = 1; j <= 10; j++) {
                num <<= 1;
                if ((bulbs[i - 1] & num) > 0) {
                    change(bulbs, i, num);
                    count++;
                }
            }
        }

        bulbs[10] &= ~(1 + (1 << 11));
        if (bulbs[10] > 0) return Integer.MAX_VALUE;
        return count;
    }

    public static void change(int[] bulbs, int x, int y) {
        bulbs[x - 1] ^= y;
        bulbs[x + 1] ^= y;
        bulbs[x] ^= y + (y << 1) + (y >> 1);
    }
}
