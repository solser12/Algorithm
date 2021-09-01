package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20922_겹치는건싫어 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());
        int ans = 1;
        int left = 0;
        arr[0] = Integer.parseInt(st.nextToken());
        count[arr[0]]++;

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            count[num]++;

            while (count[num] > K) {
                count[arr[left]]--;
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }

        System.out.println(ans);
        br.close();
    }
}
