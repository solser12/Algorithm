package codingtest.kakao;

public class Kakao0403_2 {

    int[] perm;
    int ans = 0;

    public int solution(int[][] needs, int r) {

        perm = new int[15];

        for (int i = 0; i < r; i++) {
            perm[15 - 1 - i] = 1;
        }

        do {
            check(needs, r);
        } while (nextPermutation(15));

        return ans;
    }

    void check(int[][] needs, int r) {

        for (int i = 0; i < 15; i ++) {

            for (int j = 0; j < 15; j++) {

            }
        }
    }


    boolean nextPermutation(int size) {
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
