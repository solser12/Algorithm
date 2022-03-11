package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_13140_HelloWorld {

    public static int[] perm = {1, 2, 0, 3, 4, 5, 6, 7, 8, 9};
    public static HashMap<Character, Integer> mapping;
    public static char[][] helloWorld ={{'o', 'l', 'l', 'e', 'h'}, {'d', 'l' ,'r', 'o', 'w'}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        int N = Integer.parseInt(br.readLine());
        int hello = 0, world = 0;
        boolean isFind = false;

        if (33986 <= N && N <= 184010) {
            do {
                int mul = 1;
                hello = 0;
                world = 0;
                for (int j = 0; j < 5; j++) {
                    hello += perm[mapping.get(helloWorld[0][j])] * mul;
                    world += perm[mapping.get(helloWorld[1][j])] * mul;
                    mul *= 10;
                }

                if (hello + world == N) {
                    isFind = true;
                    break;
                }
            } while (nextPermutation());
        }

        System.out.println(isFind ? print(N, hello, world) : "No Answer");
        br.close();
    }

    public static String print(int N, int hello, int world) {
        StringBuilder sb = new StringBuilder();

        sb.append("  ").append(hello).append('\n')
                .append("+ ").append(world).append('\n')
                .append("-------\n")
                .append(N >= 100000 ? " " : "  ").append(N);

        return sb.toString();
    }

    public static void init() {
        mapping = new HashMap<>();
        mapping.put('h', 0);
        mapping.put('w', 1);
        mapping.put('e', 2);
        mapping.put('o', 3);
        mapping.put('l', 4);
        mapping.put('r', 5);
        mapping.put('d', 6);
    }

    public static boolean nextPermutation() {

        int i = 9;
        while (i > 0 && perm[i - 1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = 9;
        while (perm[i - 1] >= perm[j]) j--;

        int temp = perm[i - 1];
        perm[i - 1] = perm[j];
        perm[j] = temp;

        j = 9;
        while (i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }

        return true;
    }
}
