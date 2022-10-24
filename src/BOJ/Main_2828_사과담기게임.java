package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2828_사과담기게임 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Basket basket = new Basket(M);
        int J = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < J; i++) {
            int loc = Integer.parseInt(br.readLine()) - 1;
            if (!basket.check(loc)) {
                ans += basket.move(loc);
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Basket {

        int left, right;

        public Basket(int right) {
            this.left = 0;
            this.right = right - 1;
        }

        public boolean check(int loc) {
            return left <= loc && loc <= right;
        }

        public int move(int loc) {
            int len;
            if (isLeft(loc)) {
                len = loc - left;
            } else {
                len = loc - right;
            }
            left += len;
            right += len;

            return Math.abs(len);
        }

        public boolean isLeft(int loc) {
            return left > loc;
        }
    }
}
