package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5800_성적통계 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int gap = Integer.MIN_VALUE;
            for (int j = 0; j < n - 1; j++) {
                gap = Math.max(arr[j + 1] - arr[j], gap);
            }

            sb.append(String.format("Class %d\n" +
                    "Max %d, Min %d, Largest gap %d\n", i + 1, arr[n - 1], arr[0], gap));
        }

        System.out.println(sb);
        br.close();
    }
}