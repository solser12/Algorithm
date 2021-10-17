package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9007_카누선수 {

    static int k, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int[][] group = new int[4][n];

            for (int i = 0; i < 4 ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    group[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] calcGroup = new int[2][n*n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    calcGroup[0][index] = group[0][i] + group[1][j];
                    calcGroup[1][index++] = group[2][i] + group[3][j];
                }
            }

            Arrays.sort(calcGroup[0]);
            Arrays.sort(calcGroup[1]);

            sb.append(k - find(calcGroup[0], calcGroup[1])).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int find(int[] first, int[] second) {

        int ans = 0, min = Integer.MAX_VALUE;
        for (int i : first) {
            int result = binarySearch(second, k - i);
            int abs = Math.abs(result);

            if (min > abs) {
                ans = result;
                min = abs;
            } else if (min == abs && ans < 0) {
                ans = result;
            }
        }

        return ans;
    }
    public static int binarySearch(int[] arr, int num) {

        int result = 0, min = Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            int calc = num - arr[mid];
            int abs = Math.abs(calc);

            if (min > abs) {
                min = abs;
                result = calc;
            } else if (min == abs && result < 0) {
                result = calc;
            }

            if (calc > 0) {
                left = mid + 1;
            } else if (calc < 0) {
                right = mid - 1;
            } else {
                return 0;
            }
        }

        return result;
    }
}
