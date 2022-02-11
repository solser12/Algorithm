package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_7575_바이러스 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Program[] programs = new Program[N];
        HashSet<Integer> set = new HashSet<>();
        int minSize = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            if (minSize > size) {
                index = i;
                minSize = size;
            }
            programs[i] = new Program(size, br.readLine());
            set.add(i);
        }

        Program sample = programs[index];
        set.remove(index);
        for (int i = 0; i < sample.code.length - K + 1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int[] section = Arrays.copyOfRange(sample.code, i, i + K);
            int[] reverse = reverseCode(section);
            for (int j : set) {
                if (check(programs[j].code, section, makeTable(section, K), K)
                        || check(programs[j].code, reverse, makeTable(reverse, K), K)) {
                    temp.add(j);
                }
            }
            for (int remove : temp) {
                set.remove(remove);
            }
        }

        System.out.println(set.size() == 0 ? "YES" : "NO");
        br.close();
    }

    public static boolean check(int[] checkCode, int[] sampleCode, int[] table, int K) {
        int i = 0;
        for (int num : checkCode) {
            while (i > 0 && num != sampleCode[i]) {
                i = table[i - 1];
            }
            if (num == sampleCode[i]) {
                if (i == K - 1) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static int[] makeTable(int[] code, int K) {
        int[] table = new int[K];
        int j = 0;
        for (int i = 1; i < K; i++) {
            while (j > 0 && code[i] != code[j]) {
                j = table[j - 1];
            }
            if (code[i] == code[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }

    public static int[] reverseCode(int[] code) {
        int[] result = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            result[i] = code[code.length - 1 - i];
        }
        return result;
    }

    public static class Program {
        int[] code;

        public Program(int size, String input) {
            StringTokenizer st = new StringTokenizer(input);
            code = new int[size];
            for (int i = 0; i < size; i++) {
                code[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
