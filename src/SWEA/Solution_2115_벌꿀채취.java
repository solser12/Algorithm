package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {

    static int N, M, C, ans;
    static int[][] honey;
    static int max;
    static int[] nextPerm;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            honey = new int[N][N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    checkBest(i, j, findMax(i, j));
                }
            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    // 한 구간에서 최대의 꿀을 뽑을 수 있는 다른 구간
    static void checkBest(int x, int y, int maxHoney) {
        int j = M + y;
        for (int i = x; i < N; i++) {
            while (j < N - M + 1) {
                int temp = maxHoney + findMax(i, j);
                ans = Math.max(temp, ans);
                j++;
            }
            j = 0;
        }
    }

    // 구간에서 최대의 꿀을 찾는 방법
    static int findMax(int x, int y) {
        max = 0;
        nextPerm = new int[M];
        int sum, realSum;

        for (int i = M; i >= 1; i--) {
            for (int j = 0; j < M - i; j++) {
                nextPerm[j] = 0;
            }
            for (int j = M - i; j < M; j++) {
                nextPerm[j] = 1;
            }

            do {
                sum = 0;
                realSum = 0;
                for (int k = 0; k < M; k++) {
                    if (nextPerm[k] != 0) {
                        sum += honey[x][y + k];
                        if (sum > C) break;
                        realSum += honey[x][y + k] * honey[x][y + k];
                    }
                    if (k == M-1) {
                        max = Math.max(realSum, max);
                    }
                }
            } while(nextPermuation());

        }

        return max;
    }

    static boolean nextPermuation() {
        int i = M - 1;
        while (i > 0 && nextPerm[i-1] >= nextPerm[i]) i--;
        if (i == 0) return false;

        int j = M - 1;
        while(nextPerm[i-1] >= nextPerm[j]) j--;

        int temp = nextPerm[i-1];
        nextPerm[i-1] = nextPerm[j];
        nextPerm[j] = temp;

        j = M - 1;
        while (i < j) {
            temp = nextPerm[i];
            nextPerm[i++] = nextPerm[j];
            nextPerm[j--] = temp;
        }

        return true;
    }
}
