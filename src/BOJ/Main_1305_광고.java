package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1305_광고 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] table = new int[N];
        String input = br.readLine();

        int j = 0;
        for (int i = 1; i < N; i++) {
            while (j > 0 && input.charAt(i) != input.charAt(j)) {
                j = table[j - 1];
            }
            if (input.charAt(i) == input.charAt(j)) {
                table[i] = ++j;
            }
        }

        System.out.println(N - table[N - 1]);
        br.close();
    }
}
