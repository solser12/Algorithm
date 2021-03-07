package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

    static int N, M, K;
    static int[][] array;
    static int[][] clone;
    static int[][] cycle;
    static int[] npList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new int[N][M];
        clone = new int[N][M];
        cycle = new int[K][3];
        npList = new int[K];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < K; i++) {
            npList[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cycle[i][0] = Integer.parseInt(st.nextToken()) - 1;
            cycle[i][1] = Integer.parseInt(st.nextToken()) - 1;
            cycle[i][2] = Integer.parseInt(st.nextToken());
        }

        do {
            copyArray();
            for (int i = 0; i < K; i++) {
                arrayCycle(npList[i]);
            }
            int size = checkSize();
            ans = size < ans ? size : ans;
        } while (nextPermutation());

        System.out.println(ans);
        br.close();
    }

    static int checkSize() {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += clone[i][j];
            }
            result = result > sum ? sum : result;
        }
        return result;
    }

    static void arrayCycle(int idx) {

        for (int s = 1; s <= cycle[idx][2]; s++) {
            int startx = cycle[idx][0] - s;
            int starty = cycle[idx][1] - s;
            int endx = cycle[idx][0] + s;
            int endy = cycle[idx][1] + s;
            int temp = clone[startx][starty];

            // down
            for (int i = startx; i < endx; i++) {
                clone[i][starty] = clone[i+1][starty];
            }

            // right
            for (int i = starty; i < endy; i++) {
                clone[endx][i] = clone[endx][i+1];
            }

            // up
            for (int i = endx; i > startx; i--) {
                clone[i][endy] = clone[i-1][endy];
            }

            // down
            for (int i = endy; i > starty; i--) {
                if (i == starty + 1) {
                    clone[startx][i] = temp;
                    break;
                }
                clone[startx][i] = clone[startx][i-1];
            }
        }
    }

    static void copyArray() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                clone[i][j] = array[i][j];
            }
        }
    }

    static boolean nextPermutation() {

        int i = K - 1;
        while(i > 0 && npList[i-1] >= npList[i]) --i;

        if (i == 0) return false;

        int j = K - 1;;
        while(npList[i-1] >= npList[j]) --j;

        int temp = npList[i-1];
        npList[i-1] = npList[j];
        npList[j] = temp;

        j = K - 1;
        while(i < j) {
            temp = npList[i];
            npList[i++] = npList[j];
            npList[j--] = temp;
        }

        return true;
    }
}
