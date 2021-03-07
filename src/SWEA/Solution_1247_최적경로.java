package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {

    static int N;
    static int[][] list;
    static int[] npList;
    static int ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new int[N+2][2];
            npList = new int[N];

            for (int i = 0; i < N; i++) {
                npList[i] = i;
            }

            for (int i = 0; i < N + 2; i++) {
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }

            do {
                int sum = 0;

                sum += (Math.abs(list[0][0] - list[npList[0]+2][0])) + (Math.abs(list[0][1] - list[npList[0]+2][1]));

                for (int i = 1; i < npList.length; i++) {
                    sum += (Math.abs(list[npList[i-1]+2][0] - list[npList[i]+2][0]) + Math.abs(list[npList[i-1]+2][1] - list[npList[i]+2][1]));
                }

                sum += (Math.abs(list[1][0] - list[npList[N-1]+2][0])) + (Math.abs(list[1][1] - list[npList[N-1]+2][1]));

                ans = ans > sum ? sum : ans;

            } while(nextPermutation());

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static boolean nextPermutation() {

        int i = N - 1;
        while(i > 0 && npList[i-1] >= npList[i]) --i;

        if (i == 0) return false;

        int j = N - 1;
        while(npList[i-1] >= npList[j]) --j;

        int temp = npList[i-1];
        npList[i-1] = npList[j];
        npList[j] = temp;

        j = N - 1;

        while(i < j) {
            temp = npList[i];
            npList[i++] = npList[j];
            npList[j--] = temp;
        }

        return true;
    }
}

