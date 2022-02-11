package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4354_문자열제곱 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals(".")) {
            int[] table = new int[input.length()];
            int j = 0;
            for (int i = 1; i < table.length; i++) {
                while (j > 0 && input.charAt(i) != input.charAt(j)) {
                    j = table[j - 1];
                }
                if (input.charAt(i) == input.charAt(j)) {
                    table[i] = ++j;
                }
            }
            int len = table.length - table[table.length - 1];

            if (table.length % len > 0) sb.append(1).append('\n');
            else sb.append(table.length / len).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
