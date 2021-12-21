package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1041_주사위 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        if (N == 1) {
            Arrays.sort(dice);
            for (int i = 0; i < 5; i++) {
                ans += dice[i];
            }
        } else {
            int[] minList = new int[3];
            minList[0] = Math.min(dice[0], dice[5]);
            minList[1] = Math.min(dice[1], dice[4]);
            minList[2] = Math.min(dice[2], dice[3]);
            Arrays.sort(minList);

            int one = minList[0];
            int two = one + minList[1];
            int three = two + minList[2];

            ans += (three * 4L) + ((N + N - 3) * 4L * two)
                    + ((long)(Math.pow(N - 2, 2) * one) + ((N - 1L) * (N - 2L) * 4 * one));
        }

        System.out.println(ans);
        br.close();
    }
}
