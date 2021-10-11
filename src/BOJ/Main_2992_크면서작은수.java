package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2992_크면서작은수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        if (nextPermutation(arr)) {
            System.out.println(String.valueOf(arr));
        } else {
            System.out.println(0);
        }

        br.close();
    }

    public static boolean nextPermutation(char[] arr) {

        int i = arr.length - 1;
        while (i > 0 && arr[i-1] >= arr[i]) i--;
        if (i == 0) return false;

        int j = arr.length - 1;
        while (arr[i-1] >= arr[j]) j--;

        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }

        return true;
    }
}
