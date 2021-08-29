package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16916_부분문자열 {

    static String S, P;
    static int[] table;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        P = br.readLine();
        table = new int[P.length()];
        makeTable();

        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != P.charAt(j)) j = table[j-1];
            if (S.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    j = table[j];
                    System.out.println(1);
                    System.exit(0);
                } else {
                    j++;
                }
            }
        }

        System.out.println(0);
        br.close();
    }

    public static void makeTable() {
        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) j = table[j - 1];
            if (P.charAt(i) == P.charAt(j)) table[i] = ++j;
        }
    }
}
