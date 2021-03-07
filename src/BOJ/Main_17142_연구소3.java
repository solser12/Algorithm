package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {

    static int M, N;
    static int[][] lab;
    static int[] perm;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        br.close();

    }

//    static boolean nextPermutation() {
//        int i = vidx - 1;
//        while (i > 0 && perm[i-1] >= perm[i]) i--;
//        if (i == 0) return false;
//
//        int j = vidx - 1;
//        while (perm[i-1] >= perm[j]) j--;
//
//        int temp = perm[i-1];
//        perm[i-1] = perm[j];
//        perm[j] = temp;
//
//        j = vidx - 1;
//        while (i < j) {
//            temp = perm[i];
//            perm[i++] = perm[j];
//            perm[j--] = temp;
//        }
//        return true;
//    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
