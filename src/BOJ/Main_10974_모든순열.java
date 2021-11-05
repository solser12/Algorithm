package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974_모든순열 {

    static int N;
    static int[] perm;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        perm = new int[N];
        for (int i = 0; i < N; i++) {
            perm[i] = i + 1;
        }

        do {
            sb.append(makeString());
        } while (nextPermutation());

        System.out.println(sb);
        br.close();
    }

    public static String makeString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < N; i++) {
            temp.append(perm[i]).append(' ');
        }
        temp.append('\n');
        return temp.toString();
    }

    public static boolean nextPermutation() {

        int i = N - 1;
        while (i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = N - 1;
        while (perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = N - 1;
        while (i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }

        return true;
    }
}
