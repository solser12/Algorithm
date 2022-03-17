package algorithm;

public class NextPermutaion {

    static int[] perm = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int size = perm.length;

    public static void main(String[] args) {

        int cnt = 1;
        do {
            if (cnt == 2222222) {
                break;
            }
            cnt++;
        } while (nextPermutation());

        for (int i : perm) {
            System.out.print(i + " ");
        }
        System.out.println();
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
