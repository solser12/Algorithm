package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_13506_카멜레온부분문자열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder().append("-1");

        char[] input = br.readLine().toCharArray();
        char[] sample = input.clone();
        int[] table = makeTable(input);
        while (true) {
            if (table[table.length - 1] == 0) {
                break;
            }
            sample = Arrays.copyOfRange(sample, 0, table[table.length - 1]);
            table = makeTable(sample);
            if (find(input, sample, table)) {
                sb.setLength(0);
                for (char c : sample) {
                    sb.append(c);
                }
                break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean find(char[] target, char[] find, int[] table) {
        int i = 0, cnt = 0;
        for (char c : target) {
            while (i > 0 && c != find[i]) {
                i = table[i - 1];
            }
            if (c == find[i]) {
                if (i == find.length - 1) {
                    i = table[i];
                    cnt++;
                } else {
                    i++;
                }
            }
        }
        return cnt > 2;
    }


    public static int[] makeTable(char[] sample) {
        int[] table = new int[sample.length];
        int j = 0;
        for (int i = 1; i < sample.length; i++) {
            while (j > 0 && sample[i] != sample[j]) {
                j = table[j - 1];
            }
            if (sample[i] == sample[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }
}
