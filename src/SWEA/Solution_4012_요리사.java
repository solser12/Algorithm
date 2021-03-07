package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

    static int N, ans;
    static int[][] data;
    static int[] nplist, temp1, temp2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            data = new int[N][N];
            nplist = new int[N];
            temp1 = new int[N / 2];
            temp2 = new int[N / 2];
            ans = Integer.MAX_VALUE;

            for (int i = N - 1; i >= N / 2; i--) {
                nplist[i] = 1;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            do {
                int idx1 = 0, idx2 = 0;
                for (int i = 0; i < N; i++) {
                    if (nplist[i] == 1) temp1[idx1++] = i;
                    else temp2[idx2++] = i;
                }

                checking();
                if (ans == 0) break;
            } while (nextPermutation());

            sb.append("#").append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void checking() {
        int sum2 = 0, sum1 = 0;

        for (int i : temp1) {
            for (int j : temp1) {
                sum1 += data[i][j];
            }
        }

        for (int i : temp2) {
            for (int j : temp2) {
                sum2 += data[i][j];
            }
        }

        ans = Math.min(ans, Math.abs(sum1 - sum2));
    }

    static boolean nextPermutation() {
        int i = N - 1;
        while(i > 0 && nplist[i-1] >= nplist[i]) --i;
        if (i == 0) return false;

        int j = N - 1;
        while(nplist[i-1] >= nplist[j]) --j;

        int temp = nplist[i-1];
        nplist[i-1] = nplist[j];
        nplist[j] = temp;

        j = N - 1;
        while(i < j) {
            temp = nplist[i];
            nplist[i++] = nplist[j];
            nplist[j--] = temp;
        }
        return true;
    }
}
