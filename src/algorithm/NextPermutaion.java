package algorithm;

import java.util.Arrays;

public class NextPermutaion {

    static int size = 8;
    static int[] perm = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {

        do {
            System.out.println(Arrays.toString(perm));
        } while (nextPermutation());
    }

    static boolean nextPermutation() {
        int i = size - 1;
        while(i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = size - 1;
        while(perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = size - 1;
        while(i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }

        return true;
    }
}
