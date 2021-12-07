package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13164_행복유치원 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num - temp;
            temp = num;
        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += arr[i];
        }

        System.out.println(ans);
        br.close();
    }
}
