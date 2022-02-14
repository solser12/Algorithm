package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3356_라디오전송 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String message = br.readLine();
        int[] table = new int[L];

        int j = 0;
        for (int i = 1; i < L; i++) {
            while (j > 0 && message.charAt(i) != message.charAt(j)) {
                j = table[j - 1];
            }
            if (message.charAt(i) == message.charAt(j)) {
                table[i] = ++j;
            }
        }

        System.out.println(L - table[L - 1]);
        br.close();
    }
}