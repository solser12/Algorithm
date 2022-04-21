package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12104_순환순열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        char[] arr = new char[A.length() * 2 - 1];
        for (int i = 0; i < A.length(); i++) {
            arr[i] = A.charAt(i);
        }
        for (int i = 0; i < A.length() - 1; i++) {
            arr[i + A.length()] = A.charAt(i);
        }

        int[] table = makeTable(B);

        int cnt = 0, j = 0;
        for (char c : arr) {
            while (j > 0 && c != B.charAt(j)) {
                j = table[j - 1];
            }
            if (c == B.charAt(j)) {
                if (j == B.length() - 1) {
                    j = table[j];
                    cnt++;
                } else {
                    j++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    public static int[] makeTable(String B) {
        int[] table = new int[B.length()];
        int j = 0;
        for (int i = 1; i < B.length(); i++) {
            while (j > 0 && B.charAt(i) != B.charAt(j)) {
                j = table[j - 1];
            }
            if (B.charAt(i) == B.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }
}
