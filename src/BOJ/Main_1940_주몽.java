package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1940_주몽 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] material = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(material);

        int left = 0, right = N - 1, ans = 0;
        while (left < right) {
            int sum = material[left] + material[right];
            if (sum > M) {
                right--;
            } else if (sum < M) {
                left++;
            } else {
                ans++;
                left++;
                right--;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
