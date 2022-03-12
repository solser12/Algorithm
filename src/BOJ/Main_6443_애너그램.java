package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6443_애너그램 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);

            do {
                sb.append(String.valueOf(arr)).append('\n');
            } while (nextPermutation(arr));
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean nextPermutation(char[] arr) {

        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i == 0) return false;

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) j--;

        char temp = arr[j];
        arr[j] = arr[i - 1];
        arr[i - 1] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[j];
            arr[j--] = arr[i];
            arr[i++] = temp;
        }

        return true;
    }
}
