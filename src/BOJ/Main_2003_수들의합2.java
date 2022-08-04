package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, right = 0, sum = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && sum < m) {
                sum += arr[right++];
            }
            if (sum == m) {
                ans++;
            }
            sum -= arr[left];
        }

        System.out.println(ans);
        br.close();
    }
}