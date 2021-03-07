package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {

    static int N, ans, sum;
    static int[] pow = new int[10];
    static int[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        pow[0] = 1;
        for (int i = 1; i <= 9; i++) {
            pow[i] = pow[i-1] * 2;
        }

        System.out.println(Arrays.toString(pow));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new int[N];
            sum = 0;
            ans = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
                sum += list[i];
            }
            Arrays.sort(list);

            do {
                check(0, 0, 0);
            } while (nextPermition());

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }


    static boolean nextPermition() {
        int i = N - 1;
        while(i > 0 && list[i-1] >= list[i]) --i;

        if (i == 0) return false;

        int j = N - 1;;
        while(list[i-1] >= list[j]) --j;

        int temp = list[i-1];
        list[i-1] = list[j];
        list[j] = temp;

        j = N - 1;
        while(i < j) {
            temp = list[i];
            list[i++] = list[j];
            list[j--] = temp;
        }

        return true;
    }

    static void check(int cnt, int left, int right) {

        if (sum - right <= left) {
            ans += pow[N-cnt];
            return;
        }

        else if (cnt == N) {
            if (left >= right) ans++;
            return;
        }

        check(cnt+1, left+list[cnt], right);
        if (left < right+list[cnt]) return;
        check(cnt+1, left, right+list[cnt]);
    }
}
