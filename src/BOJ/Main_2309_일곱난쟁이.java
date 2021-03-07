package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {

    static int[] check = {0, 0, 1, 1, 1, 1, 1, 1, 1};
    static int[] dwarf = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] result = new int[7];

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        do {
            if (Check()) {
                int idx = 0;
                for (int i = 0; i < 9; i++) {
                    if (check[i] == 1) result[idx++] = dwarf[i];
                }
                break;
            }
        } while(nextPermutation());


        Arrays.sort(result);
        for (int i : result) sb.append(i).append('\n');

        System.out.println(sb.toString());
        br.close();
    }

    static boolean Check() {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (check[i] == 1) sum += dwarf[i];
        }

        if (sum == 100) return true;
        return false;
    }

    static boolean nextPermutation() {

        int i = 8;
        while(i > 0 && check[i-1] >= check[i]) --i;

        if(i == 0) return false;

        int j = 8;
        while(check[i-1] >= check[j]) --j;

        int temp = check[i-1];
        check[i-1] = check[j];
        check[j] = temp;

        j = 8;
        while(i < j) {
            temp = check[i];
            check[i++] = check[j];
            check[j--] = temp;
        }

        return true;
    }
}
