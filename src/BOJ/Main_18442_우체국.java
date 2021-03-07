package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18442_우체국 {

    static int V, P;
    static long L;
    static Long[] village, result;
    static int[] perm;

    static Long distance = Long.MAX_VALUE;
    static Long[] saveLoc;

    public static void main(String[] args) throws IOException {

        /*
         * V : 마을 수
         * P : 우체국 수
         * L : 둘레
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());

        village = new Long[V];
        perm = new int[V];
        saveLoc = new Long[P];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            village[i] = Long.parseLong(st.nextToken());
        }

        result = village.clone();
        Arrays.sort(village);

        for (int i = 0; i < P; i++) {
            perm[V-i-1] = 1;
        }

        do {
            check();
        } while(nextPermutation());

        sb.append(distance).append('\n');

        for (int i = 0; i < P; i++) {
            for (int j = 0; j < V; j++) {
                if (saveLoc[i] == result[j]) {
                    sb.append(result[j]).append(' ');
                    break;
                }
            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void check() {
        Long sum = 0L;
        for (int i = 0; i < V; i++) {
            Long temp1, temp2;
            if (perm[i] == 0) {
                // 앞쪽 우체국 찾기
                for (int j = i+1; ; j++) {
                    if (j == V) j = 0;
                    if (perm[j] == 1) {
                        temp1 = Math.min(Math.abs(village[i] - village[j]), L - Math.abs(village[i] - village[j]));
                        break;
                    }
                }
                // 뒤쪽 우체국 찾기
                for (int j = i-1; ; j--) {
                    if (j == -1) j = V - 1;
                    if (perm[j] == 1) {
                        temp2 = Math.min(Math.abs(village[i] - village[j]), L - Math.abs(village[i] - village[j]));
                        break;
                    }
                }
                sum += Math.min(temp1, temp2);
            }
            if (sum >= distance) return;
        }

        distance = sum;

        int idx = 0;
        for (int i = 0; i < V; i++) {
            if (perm[i] == 1) saveLoc[idx++] = village[i];
        }
    }

    static boolean nextPermutation() {
        int i = V - 1;
        while(i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = V - 1;
        while(perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = V - 1;
        while(i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }

        return true;
    }
}
