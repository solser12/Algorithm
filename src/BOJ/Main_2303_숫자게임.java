package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2303_숫자게임 {

    public static int ans = -1, max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }
            check(0, 0, 0, i + 1, cards);
        }

        System.out.println(ans);
        br.close();
    }

    public static void check(int depth, int next, int sum, int num, int[] cards) {
        if (depth == 3) {
            int calc = sum % 10;
            if (calc >= max) {
                max = calc;
                ans = num;
            }
            return;
        }

        for (int i = next; i < 5; i++) {
            check(depth + 1, i + 1, sum + cards[i], num, cards);
        }
    }
}