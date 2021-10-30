package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int left = Math.max(maxDP[0], maxDP[1]);
            int mid = Math.max(left, maxDP[2]);
            int right = Math.max(maxDP[1], maxDP[2]);
            maxDP[0] = left + a;
            maxDP[1] = mid + b;
            maxDP[2] = right + c;

            left = Math.min(minDP[0], minDP[1]);
            mid = Math.min(left, minDP[2]);
            right = Math.min(minDP[1], minDP[2]);
            minDP[0] = left + a;
            minDP[1] = mid + b;
            minDP[2] = right + c;
        }

        int max = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
        int min = Math.min(minDP[0], Math.min(minDP[1], minDP[2]));
        System.out.println(max + " " + min);

        br.close();
    }
}