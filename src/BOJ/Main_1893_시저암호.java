package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main_1893_시저암호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] order = br.readLine().toCharArray();
            char[] original = br.readLine().toCharArray();
            char[] encrypt = br.readLine().toCharArray();

            HashMap<Character, Integer> charToIndex = makeCharToIndex(order);
            int[] table = makeTale(original);

            ArrayList<Integer> saveShift = new ArrayList<>();
            for (int i = 0; i < order.length; i++) {
                if (check(table, original, encrypt)) {
                    saveShift.add(i);
                }

                shift(charToIndex, order, original);
            }

            if (saveShift.size() == 0) {
                sb.append("no solution\n");
            } else if (saveShift.size() == 1) {
                sb.append("unique: ").append(saveShift.get(0)).append('\n');
            } else {
                sb.append("ambiguous:");
                for (int i : saveShift) {
                    sb.append(' ').append(i);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void shift(HashMap<Character, Integer> charToIndex, char[] order, char[] original) {
        for (int i = 0; i < original.length; i++) {
            int index = (charToIndex.get(original[i]) + 1) % order.length;
            original[i] = order[index];
        }
    }
    public static int[] makeTale(char[] original) {
        int[] table = new int[original.length];
        int j = 0;
        for (int i = 1; i < original.length; i++) {
            while (j > 0 && original[i] != original[j]) {
                j = table[j - 1];
            }
            if (original[i] == original[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }

    public static boolean check(int[] table, char[] original, char[] encrypt) {
        int cnt = 0, j = 0;
        for (int i = 0; i < encrypt.length; i++) {
            while (j > 0 && encrypt[i] != original[j]) {
                j = table[j - 1];
            }
            if (encrypt[i] == original[j]) {
                if (j == original.length - 1) {
                    j = table[j];
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                } else {
                    j++;
                }
            }
        }

        return cnt == 1;
    }

    public static HashMap<Character, Integer> makeCharToIndex(char[] order) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            charToIndex.put(order[i], i);
        }
        return charToIndex;
    }

}
