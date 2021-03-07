package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Solution_1208_Flatten {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] wall = new int[100];
        int T = 10;
        int dump, max, min;
        String s;

        for (int t = 1; t <= T; t++) {

            dump = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                wall[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < dump; i++) {
                wall[findMax(wall)]--;
                wall[findMin(wall)]++;
            }

            sb.append("#").append(t).append(" ").append(wall[findMax(wall)] - wall[findMin(wall)]).append("\n");
        }

        System.out.print(sb.toString());

        br.close();
    }

    public static int findMax(int[] wall) {
        int max = -1;
        int loc = 0;

        for (int i = 0; i < 100; i++) {
            if (max < wall[i]) {
                max = wall[i];
                loc = i;
            }
        }

        return loc;
    }

    public static int findMin(int[] wall) {
        int min = 101;
        int loc = 0;

        for (int i = 0; i < 100; i++) {
            if (min > wall[i]) {
                min = wall[i];
                loc = i;
            }
        }

        return loc;
    }
}