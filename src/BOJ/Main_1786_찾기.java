package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1786_찾기 {

    static String input, find;
    static int[] table;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        input = br.readLine();
        find = br.readLine();
        table = new int[find.length()];
        makeTable();

        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            while (j > 0 && input.charAt(i) != find.charAt(j)) j = table[j-1];
            if (input.charAt(i) == find.charAt(j)) {
                if (j == find.length() - 1) {
                    j = table[j];
                    cnt++;
                    sb.append(i - find.length() + 2).append('\n');
                }
                else {
                    j++;
                }
            }
        }

        sb.insert(0, cnt + "\n");
        System.out.println(sb.toString());
        br.close();
    }

    static void makeTable() {
        int j = 0;
        for (int i = 1; i < find.length(); i++) {
            while(j > 0 && find.charAt(i) != find.charAt(j)) j = table[j - 1];
            if (find.charAt(i) == find.charAt(j)) table[i] = ++j;
        }
    }
}
